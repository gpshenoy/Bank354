/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bank354.util;

import bank354.javamoney.MyCurrencyUnit;
import bank354.javamoney.MyMoneyImpl;
import javax.money.MonetaryAmount;

/**
 *
 * @author gshenoy
 */
public class Bank {

    public static MyCurrencyUnit DEFAULT_CURRENCY = new MyCurrencyUnit(MyCurrencyUnit._USD, MyCurrencyUnit.USD, 2);

    private static Bank instance;
    private MonetaryAmount deposit;

    private Bank() {
        deposit = MyMoneyImpl.of(0L, DEFAULT_CURRENCY);
    }

    public static Bank get() {
        if (instance == null) {
            instance = new Bank();
        }
        return instance;
    }

    public void setDeposit(MonetaryAmount deposit) {
        this.deposit = deposit;
    }

    public MonetaryAmount getDeposit() {
        return this.deposit;
    }

}
