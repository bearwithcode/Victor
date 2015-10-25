/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ice;

import accessoryinterface.Crystal;

/**
 *
 * @author victor
 */
public class iCrystal implements Crystal{

    @Override
    public void effect() {
        System.out.println("frozon +10");
    }
    
}
