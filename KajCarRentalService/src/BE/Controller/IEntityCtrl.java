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
public interface IEntityCtrl
{
    //  OBJECT ID
    public int getId();
    public void setId(int id);
    
    //  CAR
    public int getDepId();
    public void setDepId(int depId);

    public int getCatId();
    public void setCatId(int catId);

    public boolean isDamaged();

    public void setIsDamaged(boolean isDamaged);

    public boolean isFull();

    public void setIsFull(boolean isFull);

    public boolean isFixed();

    public void setIsFixed(boolean isFixed);

    //  CUSTOMER
    public int getCreditCardId();
    public void setCreditCardId(int creditCardId);

    public int getRentId();
    public void setRentId(int rentId);

    public int getTypeId();
    public void setTypeId(int typeId);
    
    //  RENT
    public int getCarId();
    public void setCarid(int carId);
    
    public int getCustomerId();
    public void setCustomerId(int customerId);
    
    public int getInsuranceId();
    public void setInsuranceId(int insuranceId);

    
    
}
