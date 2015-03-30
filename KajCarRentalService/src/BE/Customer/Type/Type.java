/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BE.Customer.Type;

/**
 *
 * @author notandi
 */
public class Type extends TypeCtrl
{
    private String privateCustomer;
    private String BusinessCustomer;

    public Type(String privateCustomer, String BusinessCustomer)
    {
        this.privateCustomer = privateCustomer;
        this.BusinessCustomer = BusinessCustomer;
    }

    public String getPrivateCustomer()
    {
        return privateCustomer;
    }

    public void setPrivateCustomer(String privateCustomer)
    {
        this.privateCustomer = privateCustomer;
    }

    public String getBusinessCustomer()
    {
        return BusinessCustomer;
    }

    public void setBusinessCustomer(String BusinessCustomer)
    {
        this.BusinessCustomer = BusinessCustomer;
    }
}
