/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guntype;

import accessoryinterface.Magazine;
import weaponmaker.AccessoriesFactory;
import weaponmaker.Gun;

/**
 *
 * @author victor
 */
public class Pistol extends Gun{
    AccessoriesFactory accessoriesFactory;

    public Pistol(AccessoriesFactory accessoriesFactory) {
        this.accessoriesFactory = accessoriesFactory;
        prepare();
    }
     
    @Override
    protected void prepare() {
        System.out.println("preparing for" + name);
        magazine = accessoriesFactory.createMagazine();
        crystal = accessoriesFactory.createCrystal();
        ejector = accessoriesFactory.creatEjector();
    }

    @Override
    public void printoutfig() {
        magazine.effect();
        crystal.effect();
        ejector.effect();
    }
      
    
}
