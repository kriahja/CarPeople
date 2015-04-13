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
public class Type extends EntityID
{
    private String privateCustomer;
    private String businessCustomer;

    public Type(String privateCustomer, String businessCustomer)
    {
        this.privateCustomer = privateCustomer;
        this.businessCustomer = businessCustomer;
    }
    
    public Type(int id, String privateCustomer, String businessCustomer)
    {
        setId(id);
        this.privateCustomer = privateCustomer;
        this.businessCustomer = businessCustomer;
    }
    
    public Type(int id, Type type)
    {
        this(id, type.getPrivateCustomer(), type.getBusinessCustomer());
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
        return businessCustomer;
    }

    public void setBusinessCustomer(String businessCustomer)
    {
        this.businessCustomer = businessCustomer;
    }
}
