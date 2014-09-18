/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bank354.javamoney;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Objects;
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
public class MyMoneyImpl implements MonetaryAmount, Comparable<MonetaryAmount>, Serializable {

    public static final MonetaryContext DEFAULT_MONETARY_CONEXT = MonetaryContextBuilder.of(MyMoneyImpl.class).set(RoundingMode.HALF_UP).build();

    private final CurrencyUnit currency;
    private final MonetaryContext monetaryContext;
    private Long number;
    private transient NumberValue numberValue;

    private MyMoneyImpl(Long number, CurrencyUnit currency) {
        this(number, currency, DEFAULT_MONETARY_CONEXT);
    }

    private MyMoneyImpl(Long number, CurrencyUnit currency, MonetaryContext monetaryContext) {
        this.currency = currency;
        this.number = number;
        this.monetaryContext = monetaryContext;
    }

    public static MyMoneyImpl of(Long number, CurrencyUnit currency, MonetaryContext monetaryContext) {
        return new MyMoneyImpl(number, currency, monetaryContext);
    }

    public static MyMoneyImpl of(Long number, CurrencyUnit currency) {
        return new MyMoneyImpl(number, currency);
    }

    public static MyMoneyImpl from(MonetaryAmount amt) {
        if (amt.getClass() == MyMoneyImpl.class) {
            return (MyMoneyImpl) amt;
        }
        return MyMoneyImpl.of(amt.getNumber().numberValue(Long.class), amt.getCurrency(), amt.getMonetaryContext());
    }

    @Override
    public CurrencyUnit getCurrency() {
        return currency;
    }

    @Override
    public MonetaryContext getMonetaryContext() {
        return monetaryContext;
    }

    @Override
    public NumberValue getNumber() {
        if (Objects.isNull(numberValue)) {
            numberValue = new DefaultNumberValue(this.number);
        }
        return numberValue;
    }

    @Override
    public MonetaryAmountFactory<? extends MonetaryAmount> getFactory() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean isGreaterThan(MonetaryAmount ma) {
        return number.compareTo(ma.getNumber().numberValue(Long.class)) > 0;
    }

    @Override
    public boolean isGreaterThanOrEqualTo(MonetaryAmount ma) {
        return number.compareTo(ma.getNumber().numberValue(Long.class)) > 0;
    }

    @Override
    public boolean isLessThan(MonetaryAmount ma) {
        return number.compareTo(ma.getNumber().numberValue(Long.class)) < 0;
    }

    @Override
    public boolean isLessThanOrEqualTo(MonetaryAmount ma) {
        return number.compareTo(ma.getNumber().numberValue(Long.class)) <= 0;
    }

    @Override
    public boolean isEqualTo(MonetaryAmount ma) {
        return number.compareTo(ma.getNumber().numberValue(Long.class)) == 0;
    }

    @Override
    public int signum() {
        return Long.signum(number);
    }

    @Override
    public MonetaryAmount add(MonetaryAmount ma) {
        if (ma.isZero()) {
            return this;
        }
        return new MyMoneyImpl(this.number + ma.getNumber().numberValue(Long.class), getCurrency());
    }

    @Override
    public MonetaryAmount subtract(MonetaryAmount ma) {
        if (ma.isZero()) {
            return this;
        }
        return new MyMoneyImpl(this.number - ma.getNumber().numberValue(Long.class), getCurrency());
    }

    @Override
    public MonetaryAmount multiply(long l) {
        return multiply(Long.valueOf(l));
    }

    @Override
    public MonetaryAmount multiply(double d) {
        return multiply(Double.valueOf(d));
    }

    @Override
    public MonetaryAmount multiply(Number multiplicand) {
        if (multiplicand.equals(1)) {
            return this;
        }
        return new MyMoneyImpl(number * multiplicand.longValue(), getCurrency());
    }

    @Override
    public MonetaryAmount divide(long l) {
        return divide(Long.valueOf(l));
    }

    @Override
    public MonetaryAmount divide(double d) {
        return divide(Double.valueOf(d));
    }

    @Override
    public MonetaryAmount divide(Number divisor) {
        if (divisor.equals(1)) {
            return this;
        }
        return new MyMoneyImpl(number / divisor.longValue(), getCurrency());
    }

    @Override
    public MonetaryAmount remainder(long l) {
        return remainder(Long.valueOf(l));
    }

    @Override
    public MonetaryAmount remainder(double d) {
        return remainder(Double.valueOf(d));
    }

    @Override
    public MonetaryAmount remainder(Number number) {
        return new MyMoneyImpl(this.number % number.longValue(), getCurrency());
    }

    @Override
    public MonetaryAmount[] divideAndRemainder(long l) {
        return divideAndRemainder(Long.valueOf(l));
    }

    @Override
    public MonetaryAmount[] divideAndRemainder(double d) {
        return divideAndRemainder(Double.valueOf(d));
    }

    @Override
    public MonetaryAmount[] divideAndRemainder(Number number) {
        return new MyMoneyImpl[]{(MyMoneyImpl) divide(number), (MyMoneyImpl) remainder(number)};
    }

    @Override
    public MonetaryAmount divideToIntegralValue(long l) {
        return divideToIntegralValue(Long.valueOf(l));
    }

    @Override
    public MonetaryAmount divideToIntegralValue(double d) {
        return divideToIntegralValue(Double.valueOf(d));
    }

    @Override
    public MonetaryAmount divideToIntegralValue(Number number) {
        BigDecimal divisor = new BigDecimal(number.longValue());
        BigDecimal dec = BigDecimal.valueOf(this.number).divideToIntegralValue(divisor);
        return new MyMoneyImpl(dec.longValue(), getCurrency());
    }

    @Override
    public MonetaryAmount scaleByPowerOfTen(int i) {
        return new MyMoneyImpl(BigDecimal.valueOf(this.number).scaleByPowerOfTen(i).longValue(), getCurrency());
    }

    @Override
    public MonetaryAmount abs() {
        if (this.isPositiveOrZero()) {
            return this;
        }
        return negate();
    }

    @Override
    public MonetaryAmount negate() {
        return new MyMoneyImpl(-this.number, getCurrency());
    }

    @Override
    public MonetaryAmount plus() {
        return new MyMoneyImpl(this.number + this.number, getCurrency());
    }

    @Override
    public MonetaryAmount stripTrailingZeros() {
        if (isZero()) {
            return new MyMoneyImpl(0l, getCurrency());
        }
        return new MyMoneyImpl(BigDecimal.valueOf(this.number).stripTrailingZeros().longValue(), getCurrency());
    }

    @Override
    public int compareTo(MonetaryAmount o) {
        int compare = getCurrency().getCurrencyCode().compareTo(o.getCurrency().getCurrencyCode());
        if (compare == 0) {
            compare = this.number.compareTo(MyMoneyImpl.from(o).number);
        }
        return compare;
    }

    @Override
    public String toString() {
        return getCurrency().getCurrencyCode() + ' ' + number.toString();
    }

}
