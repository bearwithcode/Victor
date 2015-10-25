/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package electricity;

import accessoryinterface.Sight;

/**
 *
 * @author victor
 */
public class eSight implements Sight{

    @Override
    public void effect() {
        System.out.println("heart bump detact");
    }
    
}
