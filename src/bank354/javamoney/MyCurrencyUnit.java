/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bank354.javamoney;

import javax.money.CurrencyContext;
import javax.money.CurrencyUnit;

/**
 *
 * @author gshenoy
 */
public class MyCurrencyUnit implements CurrencyUnit, Comparable<CurrencyUnit> {

    public static final String _USD = "USD";
    public static final String _EUR = "EUR";
    public static final Integer USD = 840;
    public static final Integer EUR = 978;

    private String currencyCode;
    private int numericCode;
    private int defaultFractionDigits;
    private CurrencyContext currencyContext;

    public MyCurrencyUnit(String currencyCode, int numericCode, int defaultFractionDigits) {
        this.currencyCode = currencyCode;
        this.numericCode = numericCode;
        this.defaultFractionDigits = defaultFractionDigits;
    }

    @Override
    public String getCurrencyCode() {
        return currencyCode;
    }

    @Override
    public int getNumericCode() {
        return numericCode;
    }

    @Override
    public int getDefaultFractionDigits() {
        return defaultFractionDigits;
    }

    @Override
    public int compareTo(CurrencyUnit o) {
        return this.currencyCode.compareTo(o.getCurrencyCode());
    }

    @Override
    public CurrencyContext getCurrencyContext() {
        return currencyContext;
    }

}
