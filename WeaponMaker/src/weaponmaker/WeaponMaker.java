/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 *this program is for practicing Abstract Factory Pattern
 *this program keep me think what to choose as ingredient main body, so gun is man body, elemental is not
 */
package weaponmaker;

import category.Electricity;
import category.Elemental;
import category.Fire;
import category.Ice;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author victor
 */
public class WeaponMaker {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String option = "";
        Scanner scanner = new Scanner(System.in);
        Gun gun = null;
        Elemental elemental = null;
        List<String> types = Arrays.asList("Pistol","Rifle","Shotgun","sniffer");
        
        System.out.println("what kind of elemental muster are u going to be(F:Fire I:Ice E:Electricity)");
        System.out.print(">");
        option = scanner.next();
        
        if(option.toUpperCase().equals("F")){
            elemental = new Fire();
        }
        else if (option.toUpperCase().equals("E")) {
            elemental = new Electricity();
        }
        else if(option.toUpperCase().equals("I")){
            elemental = new Ice();
        }
        
        System.out.println("Choose type of gun <1>" + types.get(0) + " <2>" + types.get(1) + " <3>" + types.get(2) + " <4>" + types.get(3));
        System.out.print(">");
        option = scanner.next();
        gun = elemental.createGun(option);
        
        System.out.println(gun.getName());
        gun.printoutfig();
    }
    
}
