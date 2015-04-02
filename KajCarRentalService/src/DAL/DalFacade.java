/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import BE.Car;
import DAL.DB.CarDBManager;
import java.io.IOException;

/**
 *
 * @author notandi
 */
public class DalFacade
{
    private ICRUDmanager<Car> carManager;
    
    public ICRUDmanager<Car> getCarManager() throws IOException
    {
        if(carManager == null)
        {
            carManager = CarDBManager.getInstance();
        }
        return carManager;
    }
}
