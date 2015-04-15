/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL.DB;

import BE.Car;
import BE.Customer;
import BLL.Exceptions.KajCarExceptions;
import DAL.DBConnectionManager;
import DAL.ICRUDmanager;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author notandi
 */
public class CarDBManager implements ICRUDmanager<Car>
{

    private final DBConnectionManager cm;

    private static CarDBManager instance = null;

    public static CarDBManager getInstance() throws IOException
    {
        if (instance == null)
        {
            instance = new CarDBManager();
        }
        return instance;
    }

    private CarDBManager() throws IOException
    {
        cm = DBConnectionManager.getInstance();
    }

    private Car getOneCar(ResultSet rs) throws SQLException
    {

        String carName = rs.getString("CarName");
        int km = rs.getInt("KM");
//        String depName = rs.getString("Name");

        Car car = new Car(carName, km);

        return car;
    }

    private Car getOneCarWithID(ResultSet rs) throws SQLException
    {
        int id = rs.getInt("ID");
        String carName = rs.getString("CarName");
        int depId = rs.getInt("DepId");
        int catId = rs.getInt("CatId");
        int km = rs.getInt("KM");

        Car car = new Car(id, carName, depId, catId, km);

        return car;
    }

    private Car getOneCarWithChecks(ResultSet rs) throws SQLException
    {

        String carName = rs.getString("CarName");
        int km = rs.getInt("KM");
        boolean tank = rs.getBoolean("IsFull");
        boolean damage = rs.getBoolean("IsDamaged");
        boolean fix = rs.getBoolean("IsFixed");

        Car car = new Car(carName, km, tank, damage, fix);

        return car;
    }

    @Override
    public Car create(Car car)
    {
        try (Connection con = cm.getConnection())
        {
            String sql = "INSERT INTO Car(CarName, KM, depId, catId, "
                    + " isDamaged, isFull) VALUES (?, ?, ?, ?, false, true)";
            PreparedStatement ps = con.prepareStatement(sql,
                    PreparedStatement.RETURN_GENERATED_KEYS);
            ps.setString(1, car.getName());
            ps.setInt(2, car.getKm());
            ps.setInt(3, car.getDepId());
            ps.setInt(4, car.getCatId());

            ResultSet keys = ps.getGeneratedKeys(); //
            keys.next();                            // 
            int id = keys.getInt(1);                // changed here because we want t create a car not get an existing one

            return new Car(id, car);                //
        }
        catch (SQLException ex)
        {
            throw new KajCarExceptions("Unable to create new Car data.");
        }

    }

    @Override
    public List<Car> readAll()
    {
        try (Connection con = cm.getConnection())
        {
            ArrayList<Car> carList = new ArrayList<>();
            String sql = "Select * from Car";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);

            while (rs.next())
            {
                Car car = getOneCar(rs);
                carList.add(car);
            }
            return carList;
        }
        catch (SQLException ex)
        {

            throw new KajCarExceptions("Unable to read all Car data.");
        }
    }

    public ArrayList<Car> readAllChecks()
    {
        try (Connection con = cm.getConnection())
        {
            ArrayList<Car> carList = new ArrayList<>();
            String sql = "Select * from Car";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);

            while (rs.next())
            {
                Car car = getOneCarWithChecks(rs);
                carList.add(car);
            }
            return carList;
        }
        catch (SQLException ex)
        {

            throw new KajCarExceptions("Unable to read all CarCheck data.");
        }
    }

    public Car readName(String carName)
    {
        try (Connection con = cm.getConnection())
        {
            String sql = "SELECT * FROM Car WHERE CarName = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, carName);

            ResultSet rs = ps.executeQuery();
            if (rs.next())
            {
                return getOneCarWithID(rs);
            }
        }
        catch (SQLException ex)
        {
            throw new KajCarExceptions("Unable to read Car name.");
        }
        return null;
    }

    @Override
    public Car readId(int id)
    {
        try (Connection con = cm.getConnection())
        {
            String sql = "SELECT * FROM Car Join Department ON Car.depId = Department.ID WHERE ID = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();
            if (rs.next())
            {
                return getOneCar(rs);
            }
        }
        catch (SQLException ex)
        {
            throw new KajCarExceptions("Unable to read Car id.");
        }
        return null;
    }

    @Override
    public void update(Car car)
    {
        try (Connection con = cm.getConnection())
        {
            String sql = "UPDATE car SET CarName = ?, KM = ? WHERE ID = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, car.getName());
            ps.setInt(2, car.getKm());

            ps.executeUpdate();
        }
        catch (SQLException ex)
        {
            throw new KajCarExceptions("Unable to update car data.");
        }
    }

    public void advancedUpdate(Car car)
    {
        try (Connection con = cm.getConnection())
        {
            String sql = "UPDATE car SET CarName = ?, KM = ?, DepId = ?, CatId = ? WHERE ID = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, car.getName());
            ps.setInt(2, car.getKm());
            ps.setInt(3, car.getDepId());

            ps.setInt(4, car.getCatId());
            ps.setInt(5, car.getId());

            ps.executeUpdate();
        }
        catch (SQLException ex)
        {
            throw new KajCarExceptions("Unable to perform advanced update to Car data.");
        }
    }

    @Override
    public void delete(int id)
    {
        try (Connection con = cm.getConnection())
        {
            String sql = "DELETE FROM Car WHERE ID = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);

            ps.executeUpdate();

        }
        catch (SQLException ex)
        {
            throw new KajCarExceptions("Unable to remove Car.");
        }
    }

    public ArrayList<Car> readDepId(int id)
    {
        try (Connection con = cm.getConnection())
        {
            ArrayList<Car> carList = new ArrayList<>();
            String sql = "SELECT * FROM Car WHERE DepId = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();
            if (rs.next())
            {
                Car car = getOneCar(rs);
                carList.add(car);
            }

            return carList;
        }
        catch (SQLException ex)
        {
            throw new KajCarExceptions("Unable to read Car depid.");
        }
    }

    public ArrayList<Car> readCatId(int id)
    {
        try (Connection con = cm.getConnection())
        {
            ArrayList<Car> carList = new ArrayList<>();
            String sql = "SELECT * FROM Car WHERE CatId = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();
            while (rs.next())
            {
                Car car = getOneCar(rs);
                carList.add(car);
            }

            return carList;
        }
        catch (SQLException ex)
        {
            throw new KajCarExceptions("Unable to read Car catid.");
        }

    }

    public ArrayList<Car> getByKm(int km)
    {
        try (Connection con = cm.getConnection())
        {
            ArrayList<Car> carList = new ArrayList<>();
            String sql = "SELECT * FROM Car WHERE KM = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, km);

            ResultSet rs = ps.executeQuery();
            if (rs.next())
            {
                Car car = getOneCar(rs);
                carList.add(car);
            }

            return carList;
        }
        catch (SQLException ex)
        {
            throw new KajCarExceptions("Unable to read Car km.");
        }
    }

}
