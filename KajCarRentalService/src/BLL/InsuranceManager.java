/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BLL;

import BE.Insurance;
import DAL.DB.InsurranceDBManager;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author a.tamas
 */
public class InsuranceManager {
    
    private static InsuranceManager instance = null;

    private static InsurranceDBManager db;
    

    private InsuranceManager()
    {
       
        try {
            db = InsurranceDBManager.getInstance();
        } catch (IOException ex) {
            Logger.getLogger(InsuranceManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static InsuranceManager getInstance()
    {
        if (instance == null)
        {
            instance = new InsuranceManager();
        }
        return instance;
    }
    
    public Insurance getById(int id)
    {
        return db.readId(id);
    }
}
