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
public class Customer extends EntityCtrl
{

    private String name;
    private String address;
    private String driversLicenceNo;

    public Customer(String name, String address, String driversLicenceNo)
    {
        this.name = name;
        this.address = address;
        this.driversLicenceNo = driversLicenceNo;

    }

    public Customer(int id, String name, String address, String driversLicenceNo)
    {
        setId(id);
        this.name = name;
        this.address = address;
        this.driversLicenceNo = driversLicenceNo;
    }

    /**
     * @return the name
     */
    public String getName()
    {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name)
    {
        this.name = name;
    }

    /**
     * @return the address
     */
    public String getAddress()
    {
        return address;
    }

    /**
     * @param address the address to set
     */
    public void setAddress(String address)
    {
        this.address = address;
    }

    /**
     * @return the driversLicenceNo
     */
    public String getDriversLicenceNo()
    {
        return driversLicenceNo;
    }

    /**
     * @param driversLicenceNo the driversLicenceNo to set
     */
    public void setDriversLicenceNo(String driversLicenceNo)
    {
        this.driversLicenceNo = driversLicenceNo;
    }

    @Override
    public String toString()
    {
        return "Customer{" + "name=" + name + ", address=" + address + ", driversLicenceNo=" + driversLicenceNo + '}';
    }



}
