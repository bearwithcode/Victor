/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package category;

import guntype.Pistol;
import guntype.Rifle;
import guntype.Shotgun;
import guntype.Sniffer;
import ice.iAccessoriesFactory;
import weaponmaker.AccessoriesFactory;
import weaponmaker.Gun;

/**
 *
 * @author victor
 */
public class Ice extends Elemental{

    @Override
    public Gun createGun(String type) {
       Gun gun = null;
       AccessoriesFactory acceoriesFactory = new iAccessoriesFactory();
       
       switch(type){
           case "1":
               gun = new Pistol(acceoriesFactory);
               gun.setName("frozon lady finger");
               break;
           case "2":
               gun = new Rifle(acceoriesFactory);
               gun.setName("frozon worrior");
               break;
           case "3":
               gun = new Shotgun(acceoriesFactory);
               gun.setName("frozon giant hammer");
               break;
           case "4":
               gun = new Sniffer(acceoriesFactory);
               gun.setName("frozon skull boker");
               break;
       }
       
        gun.combline();
        gun.weld();
        gun.enchanter();
        
       return gun;
    }
    
}
