/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BE;

/**
 *
 * @author a.tamas
 */
public class Car extends EntityID
{

    private String name;
    private int depId;
    private int catId;
    private int km;
    private boolean isDamaged;
    private boolean isFull;
    private boolean isFixed;

    public Car(String name, int depId, int catId, int km, boolean isDamaged, boolean isFull, boolean isFixed)
    {
        this.name = name;
        this.depId = depId;
        this.catId = catId;
        this.km = km;
        this.isDamaged = isDamaged;
        this.isFull = isFull;
        this.isFixed = isFixed;
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
     * @param isDamaged the isDamaged to set
     */
    public void setIsDamaged(boolean isDamaged)
    {
        this.isDamaged = isDamaged;
    }

    /**
     * @return the isFull
     */
    public boolean isIsFull()
    {
        return isFull;
    }

    /**
     * @param isFull the isFull to set
     */
    public void setIsFull(boolean isFull)
    {
        this.isFull = isFull;
    }

    /**
     * @return the isFixed
     */
    public boolean isIsFixed()
    {
        return isFixed;
    }

    /**
     * @param isFixed the isFixed to set
     */
    public void setIsFixed(boolean isFixed)
    {
        this.isFixed = isFixed;
    }

    @Override
    public String toString()
    {
        return "Car{" + "name= " + name + ", depId= " + depId + ", catId= " + catId + ", km= " + km + ", isDamaged= " + isDamaged + ", isFull= " + isFull + ", isFixed= " + isFixed + '}';
    }
    
    
}
