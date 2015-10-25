/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ice;

import accessoryinterface.Booster;
import accessoryinterface.Bump;
import accessoryinterface.Crystal;
import accessoryinterface.Ejector;
import accessoryinterface.Magazine;
import accessoryinterface.Sight;
import accessoryinterface.Stable;
import weaponmaker.AccessoriesFactory;

/**
 *
 * @author victor
 */
public class iAccessoriesFactory implements AccessoriesFactory{

    @Override
    public Booster createBooster() {
        return new iBooster();
    }

    @Override
    public Bump createBump() {
        return new iBump();
    }

    @Override
    public Crystal createCrystal() {
        return new iCrystal();
    }

    @Override
    public Ejector creatEjector() {
        return new iEjector();
    }

    @Override
    public Magazine createMagazine() {
        return new iMagazine();
    }

    @Override
    public Sight createSight() {
        return new iSight();
    }

    @Override
    public Stable createStable() {
        return new iStable();
    }
    
}
