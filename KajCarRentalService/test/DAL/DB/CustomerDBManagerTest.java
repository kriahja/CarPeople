/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL.DB;

import BE.Controller.EntityID;
import BE.Customer;
import java.io.IOException;
import org.junit.*;
import static org.junit.Assert.*;

/**
 *
 * @author notandi
 */
public class CustomerDBManagerTest
{
    
    private CustomerDBManager db;
    Customer cust;
    EntityID ec;
    
    @Before
    public void testSetUp() throws IOException
    {
        db = CustomerDBManager.getInstance();
        //cust = new Customer("John", "ingemanns", "1234");
        cust = new Customer(1, cust);

    }

    /**
     * Test of getInstance method, of class CustomerDBManager.
     */
    @Test
    public void testGetInstance() throws Exception
    {
    }

    /**
     * Test of create method, of class CustomerDBManager.
     */
    @Test
    public void testCreate()
    {
        db.create(cust);
        assertNotNull("Should not be null",db);
    }

    /**
     * Test of readAll method, of class CustomerDBManager.
     */
    @Test
    public void testReadAll()
    {
    }

    /**
     * Test of readName method, of class CustomerDBManager.
     */
    @Test
    public void testReadName()
    {
    }

    /**
     * Test of readId method, of class CustomerDBManager.
     */
    @Test
    public void testReadId()
    {
    }

    /**
     * Test of update method, of class CustomerDBManager.
     */
    @Test
    public void testUpdate()
    {
    }

    /**
     * Test of advancedUpdate method, of class CustomerDBManager.
     */
    @Test
    public void testAdvancedUpdate()
    {
    }

    /**
     * Test of delete method, of class CustomerDBManager.
     */
    @Test
    public void testDelete()
    {
    }
    
}
