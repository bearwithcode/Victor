/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package electricity;

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
public class eAccessoriesFactory implements AccessoriesFactory{

    @Override
    public Booster createBooster() {
        return new eBooster();
    }

    @Override
    public Bump createBump() {
        return new eBump();
    }

    @Override
    public Crystal createCrystal() {
        return new eCrystal();
    }

    @Override
    public Ejector creatEjector() {
        return new eEjector();
    }

    @Override
    public Magazine createMagazine() {
        return new eMagazine();
    }

    @Override
    public Sight createSight() {
        return new eSight();
    }

    @Override
    public Stable createStable() {
        return new eStable();
    }
    
}
