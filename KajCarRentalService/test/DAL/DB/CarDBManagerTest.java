/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL.DB;

import BE.Car;
import DAL.ICRUDmanager;
import java.io.IOException;
import java.util.List;
import org.junit.*;
import static org.junit.Assert.*;

/**
 *
 * @author notandi
 */
public class CarDBManagerTest
{

    ICRUDmanager<Car> mgr;
    Car car1;

    @Before
    public void testSetUp() throws IOException
    {
        mgr = CarDBManager.getInstance();
        car1 = new Car(1, "B", 1, 1, 1);

    }

    /**
     * Test of getInstance method, of class CarDBManager.
     */
    @Test
    public void testGetInstance() throws Exception
    {
        System.out.println("testGetInstance()");

        assertTrue(mgr instanceof CarDBManager);
    }

    /**
     * Test of create method, of class CarDBManager.
     */
    @Test
    public void testCreate() throws IOException
    {
        System.out.println("testCreate()");

        car1 = mgr.create(car1);
        assertTrue("" + car1.getId(), mgr.readId(car1.getId()).getName().equals("B"));

    }

    /**
     * Test of readAll method, of class CarDBManager.
     */
    @Test
    public void testReadAll()
    {
        System.out.println("testReadAll()");
        
        List<Car> cars = mgr.readAll();
    }

    /**
     * Test of readName method, of class CarDBManager.
     */
    @Test
    public void testReadName()
    {

    }

    /**
     * Test of readId method, of class CarDBManager.
     */
    @Test
    public void testReadId()
    {
    }

    /**
     * Test of update method, of class CarDBManager.
     */
    @Test
    public void testUpdate()
    {
    }

    /**
     * Test of advancedUpdate method, of class CarDBManager.
     */
    @Test
    public void testAdvancedUpdate()
    {
    }

    /**
     * Test of delete method, of class CarDBManager.
     */
    @Test
    public void testDelete()
    {
    }

}
