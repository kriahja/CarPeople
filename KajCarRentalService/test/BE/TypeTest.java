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
public class TypeTest
{
    private Type type;
    
    @Before
    public void testSetUp()
    {
        type = new Type("John", "BlueManGroup");
    }

    /**
     * Test of getPrivateCustomer method, of class Type.
     */
    @Test
    public void testGetPrivateCustomer()
    {
        System.out.println("testGetPrivateCustomer()");
        
        assertTrue("private customer == John", type.getPrivateCustomer().equals("John"));
    }

    /**
     * Test of setPrivateCustomer method, of class Type.
     */
    @Test
    public void testSetPrivateCustomer()
    {
        System.out.println("testSetPrivateCustomer()");
        
        type.setPrivateCustomer("Rambo");
        assertTrue("private customer changed to Rambo", type.getPrivateCustomer().equals("Rambo"));
    }

    /**
     * Test of getBusinessCustomer method, of class Type.
     */
    @Test
    public void testGetBusinessCustomer()
    {
        System.out.println("testGetBusinessCustomer()");
        
        assertTrue("Business customer == BlueManGroup", type.getBusinessCustomer().equals("BlueManGroup"));
    }

    /**
     * Test of setBusinessCustomer method, of class Type.
     */
    @Test
    public void testSetBusinessCustomer()
    {
        System.out.println("testSetBusinessCustomer()");
        
        type.setBusinessCustomer("RedManGroup");
        assertTrue("Business customer changed to RedManGroup", type.getBusinessCustomer().equals("RedManGroup"));
    }
    
}
