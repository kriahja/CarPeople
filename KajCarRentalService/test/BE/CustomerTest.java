/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BE;

import org.junit.*;
import static org.junit.Assert.*;

/**
 *
 * @author notandi
 */
public class CustomerTest
{

    private Customer customer;

    @Before
    public void testSetUp()
    {
        customer = new Customer(null, null, 1111, 2222, null, 3333);
        customer.setName("John");
        customer.setAddress("Ingemanns Alle");
        customer.setDriversLicenceNo("1234");

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

        assertTrue("CredirNr should be 1111", customer.getCreditCardId() == 1111);
        assertFalse("CreditNr should not be 2222", customer.getCreditCardId() == 2222);
    }

    /**
     * Test of getRentId method, of class Customer.
     */
    @Test
    public void testGetRentId()
    {
        System.out.println("testGetRentId()");

        assertTrue("RentId should be 2222", customer.getRentId() == 2222);
        assertFalse("RentId should not be 3333", customer.getRentId() == 3333);
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

        assertTrue("TypeId should be 3333", customer.getTypeId() == 3333);
        assertFalse("TypeId should not be 1111", customer.getTypeId() == 1111);
    }

}
