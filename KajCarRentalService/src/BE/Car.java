/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BE;

import BE.Controller.*;

/**
 *
 * @author a.tamas
 */
public class Car extends EntityID
{

    private Department dep;
    private String name;
    private int km;
    private int depId;
    private int catId;
    private boolean isDamaged;
    private boolean isFull;
    private boolean isFixed;

    public Car(String name, int km)
    {
        this.name = name;
        this.km = km;
    }

    public Car(String name, int km, int depId, int catId)
    {
        this.name = name;
        this.km = km;
        this.depId = depId;
        this.catId = catId;

    }

    public Car(int id, String name, int km, int depId, int catId)
    {
        setId(id);
        this.name = name;
        this.km = km;
        this.depId = depId;
        this.catId = catId;

    }

    public Car(int id, Car car)
    {

        this(id, car.getName(), car.getKm(), car.getDepId(), car.getCatId());

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
     * @return the km
     */
    public int getKm()
    {
        return km;
    }

    /**
     * @param km the km to set
     */
    public void setKm(int km)
    {
        this.km = km;
    }

    /**
     * @return the isDamaged
     */
    public boolean isIsDamaged()
    {
        return isDamaged;
    }

    /**
     * @return the isFull
     */
    public boolean isIsFull()
    {
        return isFull;
    }

    /**
     * @return the isFixed
     */
    public boolean isIsFixed()
    {
        return isFixed;
    }

    /**
     * @return the depId
     */
    public int getDepId()
    {
        return depId;
    }

    /**
     * @return the catId
     */
    public int getCatId()
    {
        return catId;
    }

    @Override
    public String toString()
    {
        return String.format(name + " / " + km + "km");
    }

    /**
     * @param isDamaged the isDamaged to set
     */
    public void setIsDamaged(boolean isDamaged)
    {
        this.isDamaged = isDamaged;
    }

    /**
     * @param isFull the isFull to set
     */
    public void setIsFull(boolean isFull)
    {
        this.isFull = isFull;
    }

    /**
     * @param isFixed the isFixed to set
     */
    public void setIsFixed(boolean isFixed)
    {
        this.isFixed = isFixed;
    }

    /**
     * @return the dep
     */
    public Department getDep()
    {
        return dep;
    }

}
