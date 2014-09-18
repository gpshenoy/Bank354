/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bank354.javamoney;

import java.math.BigDecimal;
import javax.money.NumberValue;

/**
 *
 * @author gshenoy
 */
public class DefaultNumberValue extends NumberValue {

    private final Number number;

    public DefaultNumberValue(Number number) {
        this.number = number;
    }

    @Override
    public Class<?> getNumberType() {
        return this.number.getClass();
    }

    @Override
    public int getPrecision() {
        return BigDecimal.valueOf(number.longValue()).precision();
    }

    @Override
    public int getScale() {
        return BigDecimal.valueOf(number.longValue()).scale();
    }

    @Override
    public int intValueExact() {
        return numberValue(BigDecimal.class).intValueExact();
    }

    @Override
    public long longValueExact() {
        return numberValue(BigDecimal.class).longValueExact();
    }

    @Override
    public double doubleValueExact() {
        return numberValue(BigDecimal.class).doubleValue();
    }

    @Override
    public <T extends Number> T numberValue(Class<T> type) {
        return (T) number;
    }

    @Override
    public <T extends Number> T numberValueExact(Class<T> type) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public long getAmountFractionNumerator() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public long getAmountFractionDenominator() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int intValue() {
        return numberValue(BigDecimal.class).intValue();
    }

    @Override
    public long longValue() {
        return numberValue(BigDecimal.class).longValue();
    }

    @Override
    public float floatValue() {
        return numberValue(BigDecimal.class).floatValue();
    }

    @Override
    public double doubleValue() {
        return numberValue(BigDecimal.class).doubleValue();
    }

}
