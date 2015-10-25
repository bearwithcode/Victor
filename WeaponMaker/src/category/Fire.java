/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package category;

import fire.fAccessoriesFactory;
import guntype.Pistol;
import guntype.Rifle;
import guntype.Shotgun;
import guntype.Sniffer;
import weaponmaker.AccessoriesFactory;
import weaponmaker.Gun;

/**
 *
 * @author victor
 */
public class Fire extends Elemental{

    @Override
    public Gun createGun(String type) {
        Gun gun = null;
        AccessoriesFactory acceoriesFactory = new fAccessoriesFactory();
         
        switch(type){
            case "1":
                gun = new Pistol(acceoriesFactory);
                gun.setName("fire touch");
                break;
            case "2":
                gun = new Rifle(acceoriesFactory);
                gun.setName("fire punch");
                break;
            case "3":
                gun = new Shotgun(acceoriesFactory);
                gun.setName("meteoric shower");
                break;
            case "4":
                gun = new Sniffer(acceoriesFactory);
                gun.setName("vocano");
                break;
        } 
        
        gun.combline();
        gun.weld();
        gun.enchanter();
        
        return gun;
    }
    
}
