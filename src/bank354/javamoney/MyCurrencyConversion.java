/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bank354.javamoney;

import javax.money.CurrencyUnit;
import javax.money.MonetaryAmount;
import javax.money.convert.ConversionContext;
import javax.money.convert.CurrencyConversion;
import javax.money.convert.ExchangeRate;
import javax.money.convert.ExchangeRateProvider;

/**
 *
 * @author gshenoy
 */
public class MyCurrencyConversion implements CurrencyConversion {

    private CurrencyUnit currencyUnit;
    private ExchangeRateProvider rateProvider;

    public MyCurrencyConversion(CurrencyUnit currencyUnit, ExchangeRateProvider rateProvider) {
        this.currencyUnit = currencyUnit;
        this.rateProvider = rateProvider;
    }

    @Override
    public ConversionContext getConversionContext() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ExchangeRate getExchangeRate(MonetaryAmount ma) {
        return this.rateProvider.getExchangeRate(ma.getCurrency(), getCurrency());
    }

    @Override
    public MonetaryAmount apply(MonetaryAmount t) {

        ExchangeRate rate = getExchangeRate(t);
        return t.multiply(rate.getFactor());
    }

    @Override
    public CurrencyUnit getCurrency() {
        return currencyUnit;
    }

}
