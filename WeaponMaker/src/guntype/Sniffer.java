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
public class Sniffer extends Gun{
    AccessoriesFactory accessoriesFactory;

    public Sniffer(AccessoriesFactory accessoriesFactory) {
        this.accessoriesFactory = accessoriesFactory;
        prepare();
    }
    
    @Override
    protected void prepare() {
        booster = accessoriesFactory.createBooster();
        sight = accessoriesFactory.createSight();
        crystal = accessoriesFactory.createCrystal();
        stable = accessoriesFactory.createStable();
    }

    @Override
    public void printoutfig() {
        booster.effect();
        sight.effect();
        crystal.effect();
        stable.effect();
    }
    
}
