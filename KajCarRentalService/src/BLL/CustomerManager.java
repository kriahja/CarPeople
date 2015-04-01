/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BLL;

import BE.Customer;
import BLL.Exceptions.KajCarExceptions;
import DAL.DB.CustomerDBManager;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author notandi
 */
public class CustomerManager
{

    private static CustomerManager instance = null;
    private static CustomerDBManager db;
    private List<Customer> customers;

    private CustomerManager()
    {
        customers = new ArrayList<>();
        try
        {
            db = CustomerDBManager.getInstance();
        }
        catch (IOException ex)
        {
            throw new KajCarExceptions("Unable to connect to Customer database.");
        }
    }

    public static CustomerManager getInstance()
    {
        if (instance == null)
        {
            instance = new CustomerManager();

        }
        return instance;
    }

    public Customer getById(int id)
    {
        for (Customer c : customers)
        {
            if (c.getId() == id)
            {
                return c;
            }
        }
        return null;
    }

    public Customer getByName(String name)
    {
        for (Customer c : customers)
        {
            if (c.getName().equals(name))
            {
                return c;
            }
        }
        return null;
    }

    public Customer getByAddress(String address)
    {
        for (Customer c : customers)
        {
            if (c.getAddress().equals(address))
            {
                return c;
            }
        }
        return null;
    }

    public Customer getByRentId(int rentId)
    {
        for (Customer c : customers)
        {
            if (c.getRentId() == rentId)
            {
                return c;
            }
        }
        return null;
    }

    public Customer getByDriversLicence(String driversLicence)
    {
        for (Customer c : customers)
        {
            if (c.getDriversLicenceNo().equals(driversLicence))
            {
                return c;
            }
        }
        return null;
    }

    public Customer getByCreditCardId(int creditCardId)
    {
        for (Customer c : customers)
        {
            if (c.getCreditCardId() == creditCardId)
            {
                return c;
            }
        }
        return null;
    }

    public ArrayList<Customer> getAll()
    {
        return (ArrayList<Customer>) db.readAll();
       
    }

    public Customer addCustomer(Customer cus)
    {
        return db.create(cus);

    }

    public void removeCustomer(int cusId)
    {
        db.delete(cusId);
    }
}
