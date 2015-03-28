/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BE.Car;

/**
 *
 * @author notandi
 */
public class CarCtrl implements ICarCtrl
{

    private int id;
    private int depId;
    private int catId;
    
    private boolean isDamaged;
    private boolean isFull;
    private boolean isFixed;

    @Override
    public int getCarId()
    {
        return id;
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

}
