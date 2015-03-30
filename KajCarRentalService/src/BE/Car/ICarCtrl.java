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
public interface ICarCtrl
{

    public int getCarId();

    public int getDepId();

    public int getCatId();

    public boolean isDamaged();
    public void setIsDamaged(boolean isDamaged);

    public boolean isFull();
    public void setIsFull(boolean isFull);

    public boolean isFixed();
    public void setIsFixed(boolean isFixed);

}
