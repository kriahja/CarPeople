/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL.DB;

import BE.Car;
import BE.Controller.EntityCtrl;
import java.io.IOException;
import org.junit.*;
import static org.junit.Assert.*;

/**
 *
 * @author notandi
 */
public class CarDBManagerTest
{

    private CarDBManager db;
    private Car car;
    private EntityCtrl e;

    @Before
    public void testSetUp() throws IOException
    {
        db = CarDBManager.getInstance();
        car = new Car("Benz", 20);

        e = new EntityCtrl();
        e.setIsDamaged(false);
        e.setIsFixed(true);
        e.setIsFull(true);

    }

    /**
     * Test of getInstance method, of class CarDBManager.
     */
    @Test
    public void testGetInstance() throws Exception
    {
    }

    /**
     * Test of create method, of class CarDBManager.
     */
    @Test
    public void testCreate() throws IOException
    {
        System.out.println("testCreate()");

        db = CarDBManager.getInstance();

        db.create(car);
        assertNotNull(db);
        assertTrue(db instanceof CarDBManager);
    }

    /**
     * Test of readAll method, of class CarDBManager.
     */
    @Test
    public void testReadAll()
    {
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
