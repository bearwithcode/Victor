/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fire;

import accessoryinterface.Bump;

/**
 *
 * @author victor
 */
public class fBump implements Bump{

    @Override
    public void effect() {
        System.out.println("blind +3");
    }
    
}
