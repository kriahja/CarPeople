/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BLL;

import BE.CreditCard;
import BLL.Exceptions.KajCarExceptions;
import DAL.DB.CreditCardDBManager;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author notandi
 */
public class CreditCardManager
{

    private static CreditCardManager instance = null;
    private static CreditCardDBManager db;
    private List<CreditCard> creditCards;

    private CreditCardManager()
    {
        creditCards = new ArrayList<>();
        try
        {
            db = CreditCardDBManager.getInstance();
        }
        catch (IOException ex)
        {
            throw new KajCarExceptions("Unable to connect to CreditCard database.");
        }
    }

    public static CreditCardManager getInstance()
    {
        if (instance == null)
        {
            instance = new CreditCardManager();

        }
        return instance;
    }

    public CreditCard getById(int id)
    {
        /*
         for (CreditCard c : creditCards)
         {
         if (c.getId() == id)
         {
         return c;
         }
         }
         return null;
         */

        return db.readId(id);
    }
    
    public ArrayList<CreditCard> getByCardNumber(int cardNumber)
    {
        return db.readCardNumber(cardNumber);
    }
    
    public ArrayList<CreditCard> getByRegNumber(int regNumber)
    {
        return db.readRegNumber(regNumber);
    }
    
    public ArrayList<CreditCard> getByExp(int exp)
    {
        return db.readExp(exp);
    }

    public ArrayList<CreditCard> getAll()
    {
        return db.readAll();
    }

    public CreditCard addCreditCard(CreditCard credit)
    {
        return db.create(credit);
    }

    public void removeCreditCard(int creditId)
    {
        db.delete(creditId);
    }
    
    public void updateCreditCard(CreditCard credit)
    {
        db.update(credit);
    }
}
