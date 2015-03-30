/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BE;

import BE.Customer.Customer;
import BE.Customer.CustomerCtrl;
import org.junit.*;
import static org.junit.Assert.*;

/**
 *
 * @author notandi
 */
public class CustomerTest
{

    private Customer customer;
    private CustomerCtrl c;

    @Before
    public void testSetUp()
    {
        customer = new Customer("John", "Ingemanns Alle", "1234");
        

    }

    /**
     * Test of getName method, of class Customer.
     */
    @Test
    public void testGetName()
    {
        System.out.println("testGetName()");

        assertTrue("Should have name John", customer.getName().equals("John"));
        assertFalse("Should have name Rambo", customer.getName().equals("Rambo"));
    }

    /**
     * Test of setName method, of class Customer.
     */
    @Test
    public void testSetName()
    {
        System.out.println("testSetName()");

        customer.setName("Rambo");
        assertTrue("Name should now be Rambo", customer.getName().equals("Rambo"));

    }

    /**
     * Test of getAddress method, of class Customer.
     */
    @Test
    public void testGetAddress()
    {
        System.out.println("testGetAddress()");

        assertTrue("Address should be Ingemanns Alle", customer.getAddress().equals("Ingemanns Alle"));
        assertFalse("Should not be Ingomanns Alle", customer.getAddress().equals("Ingomanns Alle"));
    }

    /**
     * Test of setAddress method, of class Customer.
     */
    @Test
    public void testSetAddress()
    {
        System.out.println("testSetAddress()");
        
        customer.setAddress("Amazon");
        assertTrue("The address should have been changed to Amazon", customer.getAddress().equals("Amazon"));
    }

    /**
     * Test of getCreditCardId method, of class Customer.
     */
    @Test
    public void testGetCreditCardId()
    {
        System.out.println("testGetCreditCardId()");

        assertNotNull("CreditId should not be null", customer.getCreditCardId());
    }

    /**
     * Test of getRentId method, of class Customer.
     */
    @Test
    public void testGetRentId()
    {
        System.out.println("testGetRentId()");

        assertNotNull("RentId should not be null", customer.getRentId());
    }

    /**
     * Test of getDriversLicenceNo method, of class Customer.
     */
    @Test
    public void testGetDriversLicenceNo()
    {
        System.out.println("testGetDriversLicenceNo()");

        assertTrue("DriversLicenceNo should be 1234", customer.getDriversLicenceNo().equals("1234"));
        assertFalse("DriversLicenceNo should not be 4321", customer.getDriversLicenceNo().equals("4321"));
    }

    /**
     * Test of setDriversLicenceNo method, of class Customer.
     */
    @Test
    public void testSetDriversLicenceNo()
    {
        System.out.println("testSetDriversLicenceNo()");
        
        customer.setDriversLicenceNo("6666");
        assertTrue("DriversLicenceNo should have been changed to 6666", customer.getDriversLicenceNo().equals("6666"));
    }

    /**
     * Test of getTypeId method, of class Customer.
     */
    @Test
    public void testGetTypeId()
    {
        System.out.println("testGetTypeId()");

       assertNotNull("TypeId should not be null", customer.getTypeId());
    }

}
