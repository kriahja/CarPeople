/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import BE.Car;
import BE.Customer;
import BE.Rent;
import DAL.DB.CarDBManager;
import DAL.DB.CustomerDBManager;
import DAL.DB.RentDBManager;
import java.io.IOException;

/**
 *
 * @author notandi
 */
public class DalFacade
{
    private ICRUDmanager<Car> carManager;
    private ICRUDmanager<Customer> custManager;
    private ICRUDmanager<Rent> rentManager;
    
    public ICRUDmanager<Car> getCarManager() throws IOException
    {
        if(carManager == null)
        {
            carManager = CarDBManager.getInstance();
        }
        return carManager;
    }
    
    public ICRUDmanager<Customer> getCustomerManager() throws IOException
    {
        if (custManager == null)
        {
            custManager = CustomerDBManager.getInstance();
        }
        return custManager;
    }
    
        public ICRUDmanager<Rent> getRentManager() throws IOException
    {
        if (rentManager == null)
        {
            rentManager = RentDBManager.getInstance();
        }
        return rentManager;
    }
}