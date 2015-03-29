/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BLL;

import BE.Customer.Customer;
import BLL.Exceptions.KajCarExceptions;
import DAL.CustomerDBManager;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author notandi
 */
public class CustomerManager {

    private static CustomerManager instance = null;
    private static CustomerDBManager db;
    private List<Customer> customers;

    private CustomerManager() {
        customers = new ArrayList<>();
        try {
            db = CustomerDBManager.getInstance();
        } catch (IOException ex) {
            Logger.getLogger(CustomerManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static CustomerManager getInstance() {
        if (instance == null) {
            instance = new CustomerManager();

        }
        return instance;
    }

    public Customer getById(int id) {
        for (Customer c : customers) {
            if (c.getCustomerId() == id) {
                return c;
            }
        }
        return null;
    }

    public Customer getByName(String name) {
        for (Customer c : customers) {
            if (c.getName().equals(name)) {
                return c;
            }
        }
        return null;
    }

    public Customer getByAddress(String address) {
        for (Customer c : customers) {
            if (c.getAddress().equals(address)) {
                return c;
            }
        }
        return null;
    }

    public Customer getByRentId(int rentId) {
        for (Customer c : customers) {
            if (c.getRentId() == rentId) {
                return c;
            }
        }
        return null;
    }

    public Customer getByDriversLicence(String driversLicence) {
        for (Customer c : customers) {
            if (c.getDriversLicenceNo().equals(driversLicence)) {
                return c;
            }
        }
        return null;
    }

    public Customer getByCreditCardId(int creditCardId) {
        for (Customer c : customers) {
            if (c.getCreditCardId() == creditCardId) {
                return c;
            }
        }
        return null;
    }

    public ArrayList<Customer> getAll() {
        try {

            return db.getAll();
        } catch (SQLException ex) {
            Logger.getLogger(CustomerManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public Customer addCustomer(Customer cus) {
        try {
            return db.addCustomer(cus);
        } catch (SQLException ex) {

            throw new KajCarExceptions("Unable to add Customer data.");
        }

    }

    public void removeCustomer(int cusId) {
        try {
            db.removeCustomer(cusId);
        } catch (SQLException ex) {
            throw new KajCarExceptions("Unable to find and remove Customer data.");
        }
    }
}
