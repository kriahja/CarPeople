/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BLL.CustomerCar;

import BE.Car;
import BE.Customer;
import java.util.ArrayList;
import java.util.TreeMap;

/**
 *
 * @author notandi
 */
public class CustomerCarManager implements ICustomerCarManager
{
    private ArrayList<Car> cars;
    private ArrayList<Customer> customers;

    public CustomerCarManager()
    {
        cars = new ArrayList<>();
        customers = new ArrayList<>();
    }
    
    @Override
    public Car addCarToCustomer(Customer cus, Car car)
    {  
        //Here we want to put a car on a Customer
        // then the CarManager and CustomerManager can link to this class..
        return null;
    }
    
    @Override
    public void checkCustomerInfo(Customer cus)
    {
        //Want to check general information about customer like what car is beeing rented.
    }

    
    
}
