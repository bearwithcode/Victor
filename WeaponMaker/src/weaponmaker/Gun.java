/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package weaponmaker;

import accessoryinterface.Booster;
import accessoryinterface.Bump;
import accessoryinterface.Crystal;
import accessoryinterface.Ejector;
import accessoryinterface.Magazine;
import accessoryinterface.Sight;
import accessoryinterface.Stable;

/**
 *
 * @author victor
 */
public abstract class Gun {
    protected String name;
    protected Booster booster;
    protected Bump bump;
    protected Crystal crystal;
    protected Ejector ejector;
    protected Magazine magazine;
    protected Sight sight;
    protected Stable stable;
    
    protected abstract void prepare();
    
    public void combline(){
        System.out.println("combine all the accessories");
    }
    
    public void weld(){
        System.out.println("weld to make it stable");
    }
    
    public void enchanter(){
        System.out.println("enchanter with magic boost it\'s energy");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public abstract void printoutfig();
}
