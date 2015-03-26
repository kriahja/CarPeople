/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BE;

/**
 *
 * @author notandi
 */
public class Customer extends EntityID
{
    private String name;
    private String address;
    private int creditCardId;
    private int rentId;
    private String driversLicenceNo;
    private int typeId;

    public Customer(String name, String address, int creditCardId, int rentId, String driversLicenceNo, int typeId)
    {
        this.name = name;
        this.address = address;
        this.creditCardId = creditCardId;
        this.rentId = rentId;
        this.driversLicenceNo = driversLicenceNo;
        this.typeId = typeId;
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
     * @return the creditCardId
     */
    public int getCreditCardId()
    {
        return creditCardId;
    }

    /**
     * @return the rentId
     */
    public int getRentId()
    {
        return rentId;
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

    /**
     * @return the typeId
     */
    public int getTypeId()
    {
        return typeId;
    }

    @Override
    public String toString()
    {
        return "Customer{" + "name= " + name + ", address= " + address + ", creditCardId= " + creditCardId + ", rentId= " + rentId + ", driversLicenceNo= " + driversLicenceNo + ", typeId= " + typeId + '}';
    }
    
    
    
}
