/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guntype;

import weaponmaker.AccessoriesFactory;
import weaponmaker.Gun;

/**
 *
 * @author victor
 */
public class Rifle extends Gun{
    AccessoriesFactory accessoriesFactory;

    public Rifle(AccessoriesFactory accessoriesFactory) {
        this.accessoriesFactory = accessoriesFactory;
        prepare();
    }
    
    
    @Override
    protected void prepare() {
        magazine = accessoriesFactory.createMagazine();
        booster = accessoriesFactory.createBooster();
        stable = accessoriesFactory.createStable();
        crystal = accessoriesFactory.createCrystal();
    }

    @Override
    public void printoutfig() {
        magazine.effect();
        booster.effect();
        stable.effect();
        crystal.effect();
    }
    
    
}
