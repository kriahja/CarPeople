/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BLL;

import BE.Rent;
import DAL.DB.RentDBManager;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ZALI
 */
public class RentManager {

    private static RentManager instance = null;
    
    private static RentDBManager db;
    private List<Rent> rents;

    public RentManager() {
        rents = db.readAll();
        
    }

    public static RentManager getInstance() {
        if (instance == null) {
            instance = new RentManager();
        }
        return instance;
    }

    public Rent getById(int id) {
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

    public ArrayList<Rent> getCustomerId(int id) {
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

    public ArrayList<Rent> getCarId(int carId) {
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

    public ArrayList<Rent> getInsurranceId(int id) {
       /* for (Rent c : rents) {
            if (c.getInsuranceId() == id) {
                return c;
            }
        }
        return null;
        */
        return db.getByInsId(id);
    }

    public ArrayList<Rent> getStartDate( int startDate) {
       /* for (Rent c : rents) {
            if (c.getStartDate() == startDate) {
                return c;
            }
        }
        return null;
        */
        return db.getByStartDate(startDate);
    }

    public ArrayList<Rent> getEndDate(int endDate) {
       /* for (Rent c : rents) {
            if (c.getEndDate() == endDate) {
                return c;
            }
        }
        return null;
               */
        
        return db.getByEndDate(endDate);
    }

    public void addRent(Rent rent) {
        db.create(rent);
    }

    
    
}
