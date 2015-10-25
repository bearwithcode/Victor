/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package electricity;

import accessoryinterface.Booster;

/**
 *
 * @author victor
 */
public class eBooster implements Booster{

    @Override
    public void effect() {
        System.out.println("light and electric Speed + 5");
    }
    
}
