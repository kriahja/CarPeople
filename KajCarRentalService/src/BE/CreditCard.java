/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BE;

import BE.Controller.*;


/**
 *
 * @author notandi
 */
public class CreditCard extends EntityCtrl
{
    private int CardNumber;
    private int RegNumber;
    private int Exp;

    public CreditCard(int CardNumber, int RegNumber, int Exp)
    {
        this.CardNumber = CardNumber;
        this.RegNumber = RegNumber;
        this.Exp = Exp;
    }

    public int getCardNumber()
    {
        return CardNumber;
    }

    public void setCardNumber(int CardNumber)
    {
        this.CardNumber = CardNumber;
    }

    public int getRegNumber()
    {
        return RegNumber;
    }

    public void setRegNumber(int RegNumber)
    {
        this.RegNumber = RegNumber;
    }

    public int getExp()
    {
        return Exp;
    }

    public void setExp(int Exp)
    {
        this.Exp = Exp;
    }
}
