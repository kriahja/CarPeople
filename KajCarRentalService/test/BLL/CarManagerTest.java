/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BLL;

import BE.Car.Car;
import java.util.List;
import org.junit.*;
import static org.junit.Assert.*;

/**
 *
 * @author notandi
 */
public class CarManagerTest
{

    /**
     * Test of getInstance method, of class CarManager.
     */
    @Test
    public void testGetInstance()
    {
        System.out.println("testGetInstance()");
        
        CarManager mgr = null;
        assertNull(mgr);
        
        mgr = CarManager.getInstance();
        
        assertNotNull(mgr);
        assertTrue(mgr instanceof CarManager);
        
    }

    /**
     * Test of getById method, of class CarManager.
     */
    @Test
    public void testGetById()
    {
        
        
    }

    /**
     * Test of getByName method, of class CarManager.
     */
    @Test
    public void testGetByName()
    {
    }

    /**
     * Test of getByDepId method, of class CarManager.
     */
    @Test
    public void testGetByDepId()
    {
    }

    /**
     * Test of getByCatid method, of class CarManager.
     */
    @Test
    public void testGetByCatid()
    {
    }

    /**
     * Test of getByKm method, of class CarManager.
     */
    @Test
    public void testGetByKm()
    {
    }

    /**
     * Test of getIsDamaged method, of class CarManager.
     */
    @Test
    public void testGetIsDamaged()
    {
        System.out.println("testGetIsDamaged()");
        

    }

    /**
     * Test of getIsNotDamaged method, of class CarManager.
     */
    @Test
    public void testGetIsNotDamaged()
    {

        
    }

    /**
     * Test of getIsFull method, of class CarManager.
     */
    @Test
    public void testGetIsFull()
    {
    }

    /**
     * Test of getIsNotFull method, of class CarManager.
     */
    @Test
    public void testGetIsNotFull()
    {
    }

    /**
     * Test of getIsFixed method, of class CarManager.
     */
    @Test
    public void testGetIsFixed()
    {
    }

    /**
     * Test of getIsNotFixed method, of class CarManager.
     */
    @Test
    public void testGetIsNotFixed()
    {
    }
    
    @Test
    public void testAddCar()
    {
        System.out.println("testAddCar()");
        
        CarManager mgr = CarManager.getInstance();
        Car car = new Car("Benz", 10);
        
        mgr.addCar(car);
        
        //TODO
    }


}
