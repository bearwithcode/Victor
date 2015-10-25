/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package electricity;

import accessoryinterface.Crystal;

/**
 *
 * @author victor
 */
public class eCrystal implements Crystal{

    @Override
    public void effect() {
        System.out.println("stun +10,range +5");
    }
    
}
