/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BLL;

import BE.Car;
import BLL.Exceptions.KajCarExceptions;
import DAL.DB.CarDBManager;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author notandi
 */
public class CarManager
{

    private static CarManager instance = null;

    private static CarDBManager db;
    private List<Car> cars;

    private CarManager()
    {
        cars = new ArrayList<>();
        try
        {
            db = CarDBManager.getInstance();
        }
        catch (IOException ex)
        {
            throw new KajCarExceptions("Unable to connect to Car database");
        }
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
        /*
        for (Car c : cars)
        {
            if (c.getId() == id)
            {
                return c;
            }
        }
        return null;
                */
        return db.readId(id);
        
    }

    public Car getByName(String name)
    {
        /*
        for (Car c : cars)
        {
            if (c.getName().equals(name))
            {
                return c;
            }
        }
        return null;
                */
        return db.readName(name);
    }

    public ArrayList<Car> getByDepId(int depId)
    {
        /*
        for (Car c : cars)
        {
            if (c.getDepId() == depId)
            {
                return c;
            }
        }
        return null;
                */
        return db.readDepId(depId);
        
    }

    public ArrayList<Car> getByCatid(int catId)
    {
        /*
        for (Car c : cars)
        {
            if (c.getCatId() == catId)
            {
                return c;
            }
        }
        return null;
                */
        
        return db.readCatId(catId);
    }

    public ArrayList<Car> getByKm(int km)
    {
        /*
        for (Car c : cars)
        {
            if (c.getKm() == km)
            {
                return c;
            }
        }
        return null;
                */
        return db.getByKm(km);
    }

    public ArrayList<Car> getIsDamaged()
    {
        ArrayList<Car> damagedList = new ArrayList<>();
        cars = db.readAll();
        for (Car isDmg : cars)
        {
            if (isDmg.isDamaged() == true)
            {
                damagedList.add(isDmg);
            }
        }
        return damagedList;
    }

    public ArrayList<Car> getIsNotDamaged()
    {
        ArrayList<Car> unDamagedList = new ArrayList<>();
        cars = db.readAll();
        for (Car isNotDmg : cars)
        {
            if (isNotDmg.isDamaged() == false)
            {
                unDamagedList.add(isNotDmg);
            }
        }
        return unDamagedList;
    }

    public ArrayList<Car> getIsFull()
    {
        ArrayList<Car> fullFuelList = new ArrayList<>();
        cars = db.readAll();
        for (Car isFull : cars)
        {
            if (isFull.isFull() == true)
            {
                fullFuelList.add(isFull);
            }
        }
        return fullFuelList;
    }

    public List<Car> getIsNotFull()
    {
        ArrayList<Car> notFullFuelList = new ArrayList<>();
        cars = db.readAll();
        for (Car isNotFull : cars)
        {
            if (isNotFull.isFull() == false)
            {
                notFullFuelList.add(isNotFull);
            }
        }
        return notFullFuelList;
    }

    public List<Car> getIsFixed()
    {
        ArrayList<Car> fixedList = new ArrayList<>();
        cars = db.readAll();
        for (Car isFixed : cars)
        {
            if (isFixed.isFull() == true)
            {
                fixedList.add(isFixed);
            }
        }
        return fixedList;
    }

    public List<Car> getIsNotFixed()
    {
        ArrayList<Car> notFixedList = new ArrayList<>();
        cars = db.readAll();
        for (Car isNotFixed : cars)
        {
            if (isNotFixed.isFull() == false)
            {
                notFixedList.add(isNotFixed);
            }
        }
        return notFixedList;
    }

    public Car addCar(Car car)
    {
        return db.create(car);

    }

}
