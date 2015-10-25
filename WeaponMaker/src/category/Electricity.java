/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package category;

import electricity.eAccessoriesFactory;
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
public class Electricity extends Elemental{

    @Override
    public Gun createGun(String type) {
        Gun gun = null;
        AccessoriesFactory acceoriesFactory = new eAccessoriesFactory();
        
        switch(type){
            case "1":
                gun = new Pistol(acceoriesFactory);
                gun.setName("thounder kiss");
                break;
            case "2":
                gun = new Rifle(acceoriesFactory);
                gun.setName("storm muster");
                break;
            case "3":
                gun = new Shotgun(acceoriesFactory);
                gun.setName("zeus step");
                break;
            case "4":
                gun = new Sniffer(acceoriesFactory);
                gun.setName("electric eel");
                break;
        } 
        
        gun.combline();
        gun.weld();
        gun.enchanter();
        
        return gun;
    }
    
}
