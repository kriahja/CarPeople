/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BLL.CustomerCar;

import BE.Car;
import BE.Customer;

/**
 *
 * @author notandi
 */
public interface ICustomerCarManager 
{
    public Car addCarToCustomer(Customer cus, Car car);
    
    public void checkCustomerInfo(Customer cus);
    
}
