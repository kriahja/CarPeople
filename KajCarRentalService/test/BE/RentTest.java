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
public class RentTest
{
    
    private Rent rent;
    
    @Before
    public void testSetUp()
    {
        rent = new Rent(1111, 2222);
    }
    
    /**
     * Test of getStartDate method, of class Rent.
     */
    @Test
    public void testGetStartDate()
    {
        System.out.println("testGetStartDate()");
        
        assertTrue("startDate == 1111", rent.getStartDate() == 1111);
    }

    /**
     * Test of setStartDate method, of class Rent.
     */
    @Test
    public void testSetStartDate()
    {
        System.out.println("testSetStartDate()");
        
        rent.setStartDate(2222);
        assertTrue("startDate changed to 2222", rent.getStartDate() == 2222);
        assertFalse("startDate != 1111", rent.getStartDate() == 1111);
    }

    /**
     * Test of getEndDate method, of class Rent.
     */
    @Test
    public void testGetEndDate()
    {
        System.out.println("testGetEndDate()");
        
        assertTrue("endDate == 2222", rent.getEndDate() == 2222);
    }

    /**
     * Test of setEndDate method, of class Rent.
     */
    @Test
    public void testSetEndDate()
    {
        System.out.println("testSetEndDate()");
        
        rent.setEndDate(3333);
        assertTrue("endDate changed to 3333", rent.getEndDate() == 3333);
        assertFalse("endDate != 2222", rent.getEndDate() == 2222);
    }
    
}
