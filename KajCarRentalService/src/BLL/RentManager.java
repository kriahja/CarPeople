/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BLL;

import BE.Rent;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ZALI
 */
public class RentManager {
    private static RentManager instance = null;
    private List<Rent> rents;
    public RentManager() 
    {
        rents = new ArrayList<>();        
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
        for (Rent c : rents)
        {
            if (c.getId() == id)
            {
                return c;
            }
        }
        return null;
    }
    
    public Rent getCustomerId (int id)
    {
        for (Rent c : rents)
        {
            if (c.getCustomerId() == id)
            {
                return c;
            }
        }
        return null;
    }
    
    public Rent getInsurranceId (int id)
    {
        for (Rent c : rents)
        {
            if (c.insuranceId() == id)
            {
                return c;
            }
        }
        return null;
    }
    
    public Rent getStartDate (int id)
    {
        for (Rent c : rents)
        {
            if (c.getStartDate() == id)
            {
                return c;
            }
        }
        return null;
    }
    
    public Rent getEndDate (int id)
    {
        for (Rent c : rents)
        {
            if (c.getEndDate() == id)
            {
                return c;
            }
        }
        return null;
    }
    
    
}
