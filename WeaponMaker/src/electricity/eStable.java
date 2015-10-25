/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package electricity;

import accessoryinterface.Stable;

/**
 *
 * @author victor
 */
public class eStable implements Stable{

    @Override
    public void effect() {
        System.out.println("capacitance stable +1");
    }
    
}
