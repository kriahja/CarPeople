/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BLL;

import BE.Car;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author notandi
 */
public class CarManager
{

    private static CarManager instance = null;

    //   <<<<need Database Connection>>>>
    //private static CustomerDBManager db;
    private List<Car> cars;

    private CarManager()
    {
        cars = new ArrayList<>();
        // Need to finish the contructer once the DAL is created
    }

    public static CarManager getInstance()
    {
        if (instance == null)
        {
            instance = new CarManager();
        }
        return instance;
    }

    public Car getById(int id)
    {
        for (Car c : cars)
        {
            if (c.getId() == id)
            {
                return c;
            }
        }
        return null;
    }

    public Car getByName(String name)
    {
        for (Car c : cars)
        {
            if (c.getName().equals(name))
            {
                return c;
            }
        }
        return null;
    }

    public Car getByDepId(int depId)
    {
        for (Car c : cars)
        {
            if (c.getDepId() == depId)
            {
                return c;
            }
        }
        return null;
    }

    public Car getByCatid(int catId)
    {
        for (Car c : cars)
        {
            if (c.getCatId() == catId)
            {
                return c;
            }
        }
        return null;
    }

    public Car getByKm(int km)
    {
        for (Car c : cars)
        {
            if (c.getKm() == km)
            {
                return c;
            }
        }
        return null;
    }

    public List<Car> getIsDamaged()
    {
        cars = new ArrayList<>();
        for (Car isDmg : cars)
        {
            if (isDmg.isIsDamaged() == true)
            {
                return cars;
            }
        }
        return null;
    }

    public List<Car> getIsNotDamaged()
    {
        cars = new ArrayList<>();
        for (Car isNoDmg : cars)
        {
            if (isNoDmg.isIsDamaged() == false)
            {
                return cars;
            }
        }
        return null;
    }

    public List<Car> getIsFull()
    {
        cars = new ArrayList<>();
        for (Car isFull : cars)
        {
            if (isFull.isIsFull() == true)
            {
                return cars;
            }
        }
        return null;
    }

    public List<Car> getIsNotFull()
    {
        cars = new ArrayList<>();
        for (Car isNotFull : cars)
        {
            if (isNotFull.isIsFull() == false)
            {
                return cars;
            }
        }
        return null;
    }

    public List<Car> getIsFixed()
    {
        cars = new ArrayList<>();
        for (Car isFixed : cars)
        {
            if (isFixed.isIsFixed() == true)
            {
                return cars;
            }
        }
        return null;
    }

    public List<Car> getIsNotFixed()
    {
        cars = new ArrayList<>();
        for (Car isNotFixed : cars)
        {
            if (isNotFixed.isIsFixed() == false)
            {
                return cars;
            }
        }
        return null;
    }

}
