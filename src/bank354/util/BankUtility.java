/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bank354.util;

import bank354.javamoney.MyExchangeRateProvider;
import bank354.javamoney.MyMoneyImpl;
import javax.money.MonetaryAmount;
import javax.money.convert.ExchangeRate;
import javax.money.convert.ExchangeRateProvider;
import javax.money.convert.MonetaryConversions;

/**
 *
 * @author gshenoy
 */
public class BankUtility {

    public static void deposit(double d) {
        Bank.get().setDeposit(Bank.get().getDeposit().add(MyMoneyImpl.of(d, Bank.DEFAULT_CURRENCY)));
    }

    public static void withdraw(double d) {
        Bank.get().setDeposit(Bank.get().getDeposit().subtract(MyMoneyImpl.of(d, Bank.DEFAULT_CURRENCY)));
    }

    public static void roi() {
        Bank.get().setDeposit(Bank.get().getDeposit().add(Bank.get().getDeposit().multiply(10.8).divide(100)));
    }

    public static MonetaryAmount toCurrency(String code) {
        ExchangeRateProvider provider = MonetaryConversions.getExchangeRateProvider();
        ExchangeRate rate = provider.getExchangeRate("EUR", code);
        return Bank.get().getDeposit().multiply(rate.getFactor()).getFactory().setCurrency(code).create();
    }

}
