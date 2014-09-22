/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bank354.javamoney;

import java.util.HashMap;
import java.util.Map;
import javax.money.CurrencyUnit;
import javax.money.convert.ConversionQuery;
import javax.money.convert.CurrencyConversion;
import javax.money.convert.ExchangeRate;
import javax.money.convert.ExchangeRateProvider;
import javax.money.convert.ProviderContext;
import javax.money.convert.ProviderContextBuilder;
import javax.money.convert.RateType;

/**
 *
 * @author gshenoy
 */
public class MyExchangeRateProvider implements ExchangeRateProvider {

    private Map<String, Double> rateProvider = new HashMap<String, Double>();

    static MyExchangeRateProvider instance;

    public static MyExchangeRateProvider get() {
        if (instance == null) {
            instance = new MyExchangeRateProvider();
        }
        return instance;
    }

    public MyExchangeRateProvider() {

        rateProvider.put("USD", 1.3117);
        rateProvider.put("JPY", 130.71);
        rateProvider.put("BGN", 1.9558);
        rateProvider.put("CZK", 25.765);
        rateProvider.put("DKK", 7.4588);
        rateProvider.put("GBP", 0.84200);
        rateProvider.put("HUF", 300.67);
        rateProvider.put("LTL", 3.4528);
        rateProvider.put("LVL", 0.7026);
        rateProvider.put("PLN", 4.2950);
        rateProvider.put("RON", 4.4735);
        rateProvider.put("SEK", 8.7248);
        rateProvider.put("CHF", 1.2382);
        rateProvider.put("NOK", 8.0020);
        rateProvider.put("HRK", 7.5878);
        rateProvider.put("RUB", 43.8260);
        rateProvider.put("TRY", 2.7031);
        rateProvider.put("AUD", 1.4309);
        rateProvider.put("BRL", 3.0395);
        rateProvider.put("CAD", 1.3682);
        rateProvider.put("CNY", 8.0269);
        rateProvider.put("HKD", 10.1732);
        rateProvider.put("IDR", 15161.44);
        rateProvider.put("ILS", 4.7862);
        rateProvider.put("INR", 85.5820);
        rateProvider.put("KRW", 1433.50);
        rateProvider.put("MXN", 17.4784);
        rateProvider.put("MYR", 4.3666);
        rateProvider.put("NZD", 1.6505);
        rateProvider.put("PHP", 58.328);
        rateProvider.put("SGD", 1.6770);
        rateProvider.put("THB", 42.440);
        rateProvider.put("ZAR", 13.3552);
        rateProvider.put("EUR", 1.0);

    }

    @Override
    public ProviderContext getProviderContext() {
        return ProviderContextBuilder.of("BANK1", RateType.DEFERRED).set("providerDescription", "MyProvider")
                .set("days", 1).build();
    }

    @Override
    public ExchangeRate getExchangeRate(ConversionQuery cq) {

        CurrencyUnit base = cq.getBaseCurrency();
        CurrencyUnit term = cq.getCurrency();

        Double factor = rateProvider.get(term.getCurrencyCode());

        MyExchangeRate exchangeRate = new MyExchangeRate(base, term);
        exchangeRate.setFactor(new MyNumberValue(factor));

        return exchangeRate;

    }

    @Override
    public CurrencyConversion getCurrencyConversion(ConversionQuery cq) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void add(String code, Double rate) {
        rateProvider.put(code, rate);
    }

}
