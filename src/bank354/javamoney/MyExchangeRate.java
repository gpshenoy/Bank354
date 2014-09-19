/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bank354.javamoney;

import java.util.List;
import javax.money.CurrencyUnit;
import javax.money.NumberValue;
import javax.money.convert.ConversionContext;
import javax.money.convert.ExchangeRate;

/**
 *
 * @author gshenoy
 */
public class MyExchangeRate implements ExchangeRate {

    CurrencyUnit base;
    CurrencyUnit currencyUnit;
    NumberValue factor;

    public MyExchangeRate(CurrencyUnit base,
            CurrencyUnit currencyUnit) {
        this.base = base;
        this.currencyUnit = currencyUnit;
    }

    public void setFactor(NumberValue factor) {
        this.factor = factor;
    }

    @Override
    public ConversionContext getConversionContext() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public CurrencyUnit getBaseCurrency() {
        return base;
    }

    @Override
    public CurrencyUnit getCurrency() {
        return currencyUnit;
    }

    @Override
    public NumberValue getFactor() {
        return factor;
    }

    @Override
    public List<ExchangeRate> getExchangeRateChain() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
