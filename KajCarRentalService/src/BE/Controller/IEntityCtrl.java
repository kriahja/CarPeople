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

    public int getCatId();

    public boolean isDamaged();

    public void setIsDamaged(boolean isDamaged);

    public boolean isFull();

    public void setIsFull(boolean isFull);

    public boolean isFixed();

    public void setIsFixed(boolean isFixed);

    //  CUSTOMER
    public int getCreditCardId();

    public int getRentId();

    public int getTypeId();
    
    //  RENT
    public int getCarId();
    
    public int getCustomerId();
    
    public int getInsuranceId();

    
    
}
