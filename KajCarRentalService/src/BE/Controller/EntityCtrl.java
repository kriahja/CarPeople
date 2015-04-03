/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BE.Controller;

/**
 *
 * @author notandi
 */
public class EntityCtrl implements IEntityCtrl
{

    //  OBJECT ID
    private int id;
    //  CAR
    private int depId;
    private int catId;
    private boolean isDamaged;
    private boolean isFull;
    private boolean isFixed;
    //  CUSTOMER
    private int creditCardId;
    private int rentId;
    private int typeId;
    //  RENT
    private int carId;
    private int customerId;
    private int insuranceId;

    @Override
    public int getId()
    {
        return id;
    }
    
    @Override
    public void setId(int id)
    {
        this.id = id;
    }

    @Override
    public int getDepId()
    {
        return depId;
    }

    @Override
    public int getCatId()
    {
        return catId;
    }

    @Override
    public boolean isDamaged()
    {
        return isDamaged;
    }

    @Override
    public void setIsDamaged(boolean isDamaged)
    {
        this.isDamaged = isDamaged;
    }

    @Override
    public boolean isFull()
    {
        return isFull;
    }

    @Override
    public void setIsFull(boolean isFull)
    {
        this.isFull = isFull;
    }

    @Override
    public boolean isFixed()
    {
        return isFixed;
    }

    @Override
    public void setIsFixed(boolean isFixed)
    {
        this.isFixed = isFixed;
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

    @Override
    public int getCarId()
    {
        return carId;
    }

    @Override
    public int getCustomerId()
    {
        return customerId;
    }

    @Override
    public int getInsuranceId()
    {
        return insuranceId;
    }

    @Override
    public void setDepId(int depId)
    {
        this.depId = depId;
    }

    @Override
    public void setCatId(int catId)
    {
        this.catId = catId;
    }

    @Override
    public void setCreditCardId(int creditCardId)
    {
        this.creditCardId = creditCardId;
    }

    @Override
    public void setRentId(int rentId)
    {
        this.rentId = rentId;
    }

    @Override
    public void setTypeId(int typeId)
    {
        this.typeId = typeId;
    }

    @Override
    public void setCarid(int carId)
    {
        this.carId = carId;
    }

    @Override
    public void setCustomerId(int customerId)
    {
        this.customerId = customerId;
    }

    @Override
    public void setInsuranceId(int insuranceId)
    {
        this.insuranceId = insuranceId;
    }

}
