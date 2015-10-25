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
public class Shotgun extends Gun{
    AccessoriesFactory accessoriesFactory;

    public Shotgun(AccessoriesFactory accessoriesFactory) {
        this.accessoriesFactory = accessoriesFactory;
        prepare();
    }

    @Override
    protected void prepare() {
        bump = accessoriesFactory.createBump();
        crystal = accessoriesFactory.createCrystal();
        stable = accessoriesFactory.createStable();
    }

    @Override
    public void printoutfig() {
        bump.effect();
        crystal.effect();
        stable.effect();
    }

    
}
