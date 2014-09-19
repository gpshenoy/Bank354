/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bank354.javamoney;

import java.math.RoundingMode;
import javax.money.CurrencyUnit;
import javax.money.MonetaryAmount;
import javax.money.MonetaryAmountFactory;
import javax.money.MonetaryContext;
import javax.money.MonetaryContextBuilder;
import javax.money.NumberValue;

/**
 *
 * @author gshenoy
 */
public class MyMoneyImplFactory implements MonetaryAmountFactory<MyMoneyImpl> {

    static final MonetaryContext DEFAULT_CONTEXT = MonetaryContextBuilder.of(MyMoneyImpl.class).setPrecision(19).setMaxScale(5).setFixedScale(true)
            .set(RoundingMode.HALF_EVEN).build();
    private CurrencyUnit currency;
    private Number number;
    private MonetaryContext context;

    @Override
    public Class<? extends MonetaryAmount> getAmountType() {
        return MyMoneyImpl.class;
    }

    @Override
    public MonetaryAmountFactory<MyMoneyImpl> setCurrency(CurrencyUnit cu) {
        this.currency = cu;
        return this;
    }

    @Override
    public MonetaryAmountFactory<MyMoneyImpl> setNumber(double d) {
        this.number = d;
        return this;
    }

    @Override
    public MonetaryAmountFactory<MyMoneyImpl> setNumber(long l) {
        this.number = l;
        return this;
    }

    @Override
    public MonetaryAmountFactory<MyMoneyImpl> setNumber(Number number) {
        this.number = number;
        return this;
    }

    @Override
    public NumberValue getMaxNumber() {
        return MyMoneyImpl.MAX_VALUE.getNumber();
    }

    @Override
    public NumberValue getMinNumber() {
        return MyMoneyImpl.MIN_VALUE.getNumber();
    }

    @Override
    public MonetaryAmountFactory<MyMoneyImpl> setContext(MonetaryContext mc) {
        this.context = mc;
        return this;
    }

    @Override
    public MyMoneyImpl create() {
        return MyMoneyImpl.of(number.doubleValue(), currency, context);
    }

    @Override
    public MonetaryContext getDefaultMonetaryContext() {
        return DEFAULT_CONTEXT;
    }

}
