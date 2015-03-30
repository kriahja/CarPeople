/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BE.CreditCard;

/**
 *
 * @author notandi
 */
public class CreditCardCtrl implements ICreditCardCtrl
{
    private int creditCardId;

    @Override
    public int getCreditCardId()
    {
        return creditCardId;
    }
    
}
