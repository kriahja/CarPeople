/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BE;

import BE.CreditCard;
import org.junit.*;
import static org.junit.Assert.*;

/**
 *
 * @author notandi
 */
public class CreditCardTest
{
    
    private CreditCard credit;
    
    @Before
    public void testSetUp()
    {
        credit = new CreditCard(1111, 2222, 920);
        
    }

    /**
     * Test of getCardNumber method, of class CreditCard.
     */
    @Test
    public void testGetCardNumber()
    {
        System.out.println("testGetCardNumber()");
        
        assertTrue("Credit number = 1111", credit.getCardNumber() == 1111);
    }

    /**
     * Test of setCardNumber method, of class CreditCard.
     */
    @Test
    public void testSetCardNumber()
    {
        System.out.println("testSetCardNumber()");
        
        credit.setCardNumber(2222);
        assertTrue("CreditNr changed to 2222", credit.getCardNumber() == 2222);
    }

    /**
     * Test of getRegNumber method, of class CreditCard.
     */
    @Test
    public void testGetRegNumber()
    {
        System.out.println("testGetRegNumber()");
        
        assertTrue("RegNum == 2222", credit.getRegNumber() == 2222);
    }

    /**
     * Test of setRegNumber method, of class CreditCard.
     */
    @Test
    public void testSetRegNumber()
    {
        System.out.println("testSetRegNumber()");
        
        credit.setRegNumber(3333);
        assertTrue("RegNum changed to 3333", credit.getRegNumber() == 3333);
    }

    /**
     * Test of getExp method, of class CreditCard.
     */
    @Test
    public void testGetExp()
    {
        System.out.println("testGetExp()");
        
        assertTrue("Exp == 920", credit.getExp() == 920);
    }

    /**
     * Test of setExp method, of class CreditCard.
     */
    @Test
    public void testSetExp()
    {
        System.out.println("testSetExp()");
        
        credit.setExp(919);
        assertTrue("Exp changed to 919", credit.getExp() == 919);
    }
    
}
