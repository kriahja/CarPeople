/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BE;

import BLL.CarManager;
import BE.Controller.*;

/**
 *
 * @author a.tamas
 */
public class Car extends EntityCtrl
{

    private String name;
    private int km;

    public Car(String name, int km)
    {
        this.name = name;
        this.km = km;
    }

    public Car(int id, String name, int km, int depId, int catId)
    {
        setId(id);
        this.name = name;
        this.km = km;
        setDepId(depId);
        setCatId(catId);

    }

    public Car(String name, int km, int depId, int catId)
    {
        this.name = name;
        this.km = km;
        setDepId(depId);
        setCatId(catId);

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

}
