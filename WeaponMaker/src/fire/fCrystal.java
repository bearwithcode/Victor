/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fire;

import accessoryinterface.Crystal;

/**
 *
 * @author victor
 */
public class fCrystal implements Crystal{

    @Override
    public void effect() {
        System.out.println("burning +10");
    }
    
}
