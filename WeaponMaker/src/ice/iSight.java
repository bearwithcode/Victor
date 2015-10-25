/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ice;

import accessoryinterface.Sight;

/**
 *
 * @author victor
 */
public class iSight implements Sight{

    @Override
    public void effect() {
        System.out.println("vibration detact");
    }
    
}
