/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ice;

import accessoryinterface.Magazine;

/**
 *
 * @author victor
 */
public class iMagazine implements Magazine{

    @Override
    public void effect() {
        System.out.println("storm stone");
    }
    
}
