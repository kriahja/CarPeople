/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BE.Customer;

/**
 *
 * @author notandi
 */
public class CustomerCtrl implements ICustomerCtrl
{

    private int customerId;
    private int creditCardId;
    private int rentId;
    private int typeId;

    @Override
    public int getCustomerId()
    {
        return customerId;
    }

    @Override
    public int getCreditCardId()
    {
        return creditCardId;
    }

    @Override
    public int getRentId()
    {
        return rentId;
    }

    @Override
    public int getTypeId()
    {
        return typeId;
    }

}
