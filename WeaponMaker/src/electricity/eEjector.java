/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package electricity;

import accessoryinterface.Ejector;

/**
 *
 * @author victor
 */
public class eEjector implements Ejector{

    @Override
    public void effect() {
        System.out.println("splite  lightning +6");
    }
    
}
