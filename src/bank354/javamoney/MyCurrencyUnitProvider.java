/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bank354.javamoney;

import java.util.Set;
import javax.money.CurrencyQuery;
import javax.money.CurrencyUnit;
import javax.money.spi.CurrencyProviderSpi;

/**
 *
 * @author gshenoy
 */
public class MyCurrencyUnitProvider implements CurrencyProviderSpi{

    @Override
    public Set<CurrencyUnit> getCurrencies(CurrencyQuery cq) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
