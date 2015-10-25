/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fire;

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
public class fAccessoriesFactory implements AccessoriesFactory{

    @Override
    public Booster createBooster() {
        return new fBooster();
    }

    @Override
    public Bump createBump() {
        return new fBump();
    }

    @Override
    public Crystal createCrystal() {
        return new fCrystal();
    }

    @Override
    public Ejector creatEjector() {
        return new fEjector();
    }

    @Override
    public Magazine createMagazine() {
        return new fMagazine();
    }

    @Override
    public Sight createSight() {
        return new fSight();
    }

    @Override
    public Stable createStable() {
        return new fStable();
    }
    
}
