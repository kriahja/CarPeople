/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BLL;

import BE.Rent;
import BLL.Exceptions.KajCarExceptions;
import DAL.DB.RentDBManager;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ZALI
 */
public class RentManager
{

    private static RentManager instance = null;

    private static RentDBManager db;
    private List<Rent> rents;

    public RentManager() {
        try {
            db =  RentDBManager.getInstance();
        } catch (IOException ex) {
            Logger.getLogger(RentManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try
        {
            db = RentDBManager.getInstance();
//        rents = db.readAll();
        }
        catch (IOException ex)
        {
            throw new KajCarExceptions("Unable to connect to Rent database.");
        }
    }

    public static RentManager getInstance()
    {
        if (instance == null)
        {
            instance = new RentManager();
        }
        return instance;
    }

    public Rent getById(int id)
    {
        /*
         for (Rent c : rents) {
         if (c.getId() == id) {
         return c;
         }
         }
         return null;
         */
        return db.readId(id);
    }

    public ArrayList<Rent> getCustomerId(int id)
    {
        /*
         for (Rent c : rents) {
         if (c.getCustomerId() == id) {
         return c;
         }
         }
         return null;
         */
        return db.readCatId(id);
    }

    public ArrayList<Rent> getCarId(int carId)
    {
        /*
         for (Rent c : rents) {
         if (c.getCarId() == carId) {
         return c;
         }
         }
         return null;
         */
        return db.getCarId(carId);
    }

    public ArrayList<Rent> getInsurranceId(int id)
    {
        /* for (Rent c : rents) {
         if (c.getInsuranceId() == id) {
         return c;
         }
         }
         return null;
         */
        return db.getByInsId(id);
    }

    public ArrayList<Rent> getStartDate(int startDate)
    {
        /* for (Rent c : rents) {
         if (c.getStartDate() == startDate) {
         return c;
         }
         }
         return null;
         */
        return db.getByStartDate(startDate);
    }

    public ArrayList<Rent> getEndDate(int endDate)
    {
        /* for (Rent c : rents) {
         if (c.getEndDate() == endDate) {
         return c;
         }
         }
         return null;
         */

        return db.getByEndDate(endDate);
    }

    public Rent addRent(Rent rent) {
        System.out.println("elotte");
        
        return db.create(rent);             
       
    }

    public ArrayList<Rent> getAll()
    {
        return (ArrayList<Rent>) db.readAll();
    }

}
