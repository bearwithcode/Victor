/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package electricity;

import accessoryinterface.Magazine;

/**
 *
 * @author victor
 */
public class eMagazine implements Magazine{

    @Override
    public void effect() {
        System.out.println("Using Tor battery");
    }
    
}
