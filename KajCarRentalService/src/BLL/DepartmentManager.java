/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BLL;

import BE.Car;
import BE.Department;
import BLL.Exceptions.KajCarExceptions;
import DAL.DB.DepartmentDBManager;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author notandi
 */
public class DepartmentManager
{

    private static DepartmentManager instance = null;

    private static DepartmentDBManager db;
    private List<Car> cars;

    private DepartmentManager()
    {
        cars = new ArrayList<>();
        try
        {
            db = DepartmentDBManager.getInstance();
        }
        catch (IOException ex)
        {
            throw new KajCarExceptions("Unable to connect to Car database");
        }
    }

    public static DepartmentManager getInstance()
    {
        if (instance == null)
        {
            instance = new DepartmentManager();
        }
        return instance;
    }

    public Department getById(int id)
    {
        return db.readId(id);
    }

    public Department getByName(String name)
    {
        return db.readName(name);
    }

    public Department addDep(Department dep)
    {
        return db.create(dep);
    }
    
    public ArrayList<Department> getAll()
    {
        return (ArrayList<Department>) db.readAll();
    }
}
