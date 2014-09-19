/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bank354.javamoney;

import com.sun.org.apache.bcel.internal.generic.ARRAYLENGTH;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.money.convert.ConversionQuery;
import javax.money.convert.ExchangeRateProvider;
import javax.money.spi.Bootstrap;
import javax.money.spi.MonetaryConversionsSingletonSpi;

/**
 *
 * @author gshenoy
 */
public class DefaultMonetaryConversionsSingletonSpi implements MonetaryConversionsSingletonSpi {

    @Override
    public Collection<String> getProviderNames() {
        List<String> list = new ArrayList<String>();
        list.add("BANK1");
        return list;
    }

    @Override
    public List<String> getDefaultProviderChain() {
        List<String> providers = new ArrayList<>();
        for (ExchangeRateProvider prov : Bootstrap.getServices(ExchangeRateProvider.class)) {
            providers.add(prov.getProviderContext().getProvider());
        }
        return providers;
    }

    @Override
    public ExchangeRateProvider getExchangeRateProvider(ConversionQuery cq) {
        return MyExchangeRateProvider.get();
    }

}
