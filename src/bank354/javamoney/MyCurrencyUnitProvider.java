/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bank354.javamoney;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import javax.money.CurrencyQuery;
import javax.money.CurrencyUnit;
import javax.money.spi.CurrencyProviderSpi;

/**
 *
 * @author gshenoy
 */
public class MyCurrencyUnitProvider implements CurrencyProviderSpi {

    static Map<String, CurrencyUnit> codes = new HashMap<>();

    public MyCurrencyUnitProvider() {

        codes.put(MyCurrencyUnit._INR, new MyCurrencyUnit(MyCurrencyUnit._INR, MyCurrencyUnit.INR, 2));
        codes.put(MyCurrencyUnit._EUR, new MyCurrencyUnit(MyCurrencyUnit._EUR, MyCurrencyUnit.EUR, 2));
        codes.put(MyCurrencyUnit._USD, new MyCurrencyUnit(MyCurrencyUnit._USD, MyCurrencyUnit.USD, 2));
    }

    @Override
    public Set<CurrencyUnit> getCurrencies(CurrencyQuery cq) {

        Set<CurrencyUnit> set = new HashSet<>();
        for (String code : cq.getCurrencyCodes()) {
            set.add(codes.get(code));
        }
        return set;
    }

    public static void addNewCode(String code) {
        codes.put(code, new MyCurrencyUnit(code, 0, 2));
    }

}
