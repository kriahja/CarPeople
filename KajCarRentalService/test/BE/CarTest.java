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
public class CarTest
{

    private Car car;

    @Before
    public void testSetUp()
    {
        car = new Car(null, 1111, 2222, 10000, true, true, true);
        car.setName("Mercedez Bens");
        
    }

    /**
     * Test of getName method, of class Car.
     */
    @Test
    public void testGetName()
    {
        System.out.println("testGetName()");
        
        assertTrue("name should be Mercedez Bens", car.getName().equals("Mercedez Bens"));
    }

    /**
     * Test of setName method, of class Car.
     */
    @Test
    public void testSetName()
    {
        System.out.println("testSetName()");
        
        car.setName("Yaris");
        assertTrue("Name should have changed to yaris", car.getName().equals("Yaris"));
        assertFalse("Name should not be Mercedes Benz", car.getName().equals("Mercedes Benz"));
    }

    /**
     * Test of getDepId method, of class Car.
     */
    @Test
    public void testGetDepId()
    {
        System.out.println("testGetDepId()");
        
        assertTrue("DepId should be 1111", car.getDepId() == 1111);
    }

    /**
     * Test of getCatId method, of class Car.
     */
    @Test
    public void testGetCatId()
    {
        System.out.println("testGetCatId()");
        
        assertTrue("CatId should be 2222", car.getCatId() == 2222);
    }

    /**
     * Test of getKm method, of class Car.
     */
    @Test
    public void testGetKm()
    {
        System.out.println("testGetKm()");
        
        assertTrue("Km should be 10000", car.getKm() == 10000);
    }

    /**
     * Test of setKm method, of class Car.
     */
    @Test
    public void testSetKm()
    {
        System.out.println("testSetKm()");
        
        car.setKm(20000);
        assertTrue("km should have been changed to 20000", car.getKm() == 20000);
        assertFalse("km should not be 10000", car.getKm() == 10000);
    }

    /**
     * Test of isIsDamaged method, of class Car.
     */
    @Test
    public void testIsIsDamaged()
    {
        System.out.println("testIsIsDamaged()");
        
        assertTrue("Car should be damaged", car.isIsDamaged() == true);
    }

    /**
     * Test of setIsDamaged method, of class Car.
     */
    @Test
    public void testSetIsDamaged()
    {
        System.out.println("testSetIsDamaged()");
        
        car.setIsDamaged(false);
        assertTrue("Car should have changed to not damaged", car.isIsDamaged() == false);
        assertFalse("Car should not be damaged", car.isIsDamaged() == true);
    }

    /**
     * Test of isIsFull method, of class Car.
     */
    @Test
    public void testIsIsFull()
    {
        System.out.println("testIsIsFull()");
        
        assertTrue("Car should be full", car.isIsFull() == true);
        
    }

    /**
     * Test of setIsFull method, of class Car.
     */
    @Test
    public void testSetIsFull()
    {
        System.out.println("testSetIsFull()");
        
        car.setIsFull(false);
        assertTrue("Car should be not full", car.isIsFull() == false);
        assertFalse("Car should not be full", car.isIsFull() == true);
    }

    /**
     * Test of isIsFixed method, of class Car.
     */
    @Test
    public void testIsIsFixed()
    {
        System.out.println("testIsIsFixed()");
        
        assertTrue("Car should be fixed", car.isIsFixed() == true);
    }

    /**
     * Test of setIsFixed method, of class Car.
     */
    @Test
    public void testSetIsFixed()
    {
        System.out.println("testSetIsFixed()");
        
        car.setIsFixed(false);
        assertTrue("Car should not be fixed", car.isIsFixed() == false);
        assertFalse("Testing if car is fixed when it is not ", car.isIsFixed() == true);
    }


}
