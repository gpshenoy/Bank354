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
public class MyNumberValue extends NumberValue {

    private Double number;

    public MyNumberValue(Double d) {
        this.number = d;
    }

    @Override
    public Class<?> getNumberType() {
        return number.getClass();
    }

    @Override
    public int getPrecision() {
        return BigDecimal.valueOf(number).precision();
    }

    @Override
    public int getScale() {
        return BigDecimal.valueOf(number).scale();
    }

    @Override
    public int intValueExact() {
        return BigDecimal.valueOf(number).intValueExact();
    }

    @Override
    public long longValueExact() {
        return BigDecimal.valueOf(number).longValueExact();
    }

    @Override
    public double doubleValueExact() {
        return BigDecimal.valueOf(number).doubleValue();
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
        return BigDecimal.valueOf(number).intValue();
    }

    @Override
    public long longValue() {
        return BigDecimal.valueOf(number).longValue();
    }

    @Override
    public float floatValue() {
        return BigDecimal.valueOf(number).floatValue();
    }

    @Override
    public double doubleValue() {
        return BigDecimal.valueOf(number).doubleValue();
    }

}
