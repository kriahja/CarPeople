/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import BE.Car;
import BE.CreditCard;
import BE.Customer;
import BE.Rent;
import DAL.DB.CarDBManager;
import DAL.DB.CreditCardDBManager;
import DAL.DB.CustomerDBManager;
import DAL.DB.RentDBManager;
import java.io.IOException;

/**
 *
 * @author notandi
 */
public class DalFacade
{

    public ICRUDmanager<Car> getCarDBManager() throws IOException
    {
        return CarDBManager.getInstance();
    }

    public ICRUDmanager<Customer> getCustomerDBManager() throws IOException
    {
        return CustomerDBManager.getInstance();
    }

    public ICRUDmanager<Rent> getRentDBManager() throws IOException
    {
        return RentDBManager.getInstance();
    }
    public ICRUDmanager<CreditCard> getCreditCardDBManager() throws IOException
    {
        return CreditCardDBManager.getInstance();
    }
}
