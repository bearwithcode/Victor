/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package weaponmaker;

import accessoryinterface.*;

/**
 *
 * @author victor
 */
public interface AccessoriesFactory {
    public Booster createBooster();
    public Bump createBump();
    public Crystal createCrystal();
    public Ejector creatEjector();
    public Magazine createMagazine();
    public Sight createSight();
    public Stable createStable();
}
