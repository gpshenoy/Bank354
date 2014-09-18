/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bank354.util;

import bank354.javamoney.MyMoneyImpl;

/**
 *
 * @author gshenoy
 */
public class BankUtility {

    public static void deposit(long l) {
        Bank.get().setDeposit(Bank.get().getDeposit().add(MyMoneyImpl.of(l, Bank.DEFAULT_CURRENCY)));
    }

    public static void withdraw(long l) {
        Bank.get().setDeposit(Bank.get().getDeposit().subtract(MyMoneyImpl.of(l, Bank.DEFAULT_CURRENCY)));
    }

}
