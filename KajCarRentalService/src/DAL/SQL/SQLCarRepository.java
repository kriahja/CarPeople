/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL.SQL;

import BE.Car;
import BLL.Exceptions.KajCarExceptions;
import DAL.DBConnectionManager;
import DAL.ICRUDrepository;

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
public class SQLCarRepository implements ICRUDrepository<Car>
{

    private final DBConnectionManager cm;

    private static SQLCarRepository instance = null;

    public static SQLCarRepository getInstance() throws IOException
    {
        if (instance == null)
        {
            instance = new SQLCarRepository();
        }
        return instance;
    }

    private SQLCarRepository() throws IOException
    {
        cm = DBConnectionManager.getInstance();
    }

    private Car getOneCar(ResultSet rs) throws SQLException
    {

        String carName = rs.getString("Name");
        int km = rs.getInt("KM");

        Car car = new Car(carName, km);

        return car;

    }

    @Override
    public Car create(Car car)
    {
        try (Connection con = cm.getConnection())
        {
            String sql = "INSERT INTO Car(Name, depId, catId, "
                    + "km, isDamaged, isFull) VALUES (?, ?, ?, ?, false, true)";
            PreparedStatement ps = con.prepareStatement(sql,
                    PreparedStatement.RETURN_GENERATED_KEYS);
            ps.setString(1, car.getName());
            ps.setInt(2, car.getDepId());
            ps.setInt(3, car.getCatId());
            ps.setInt(4, car.getKm());

            int affectedRows = ps.executeUpdate();
            if (affectedRows == 0)
            {
                throw new SQLException("Unable to add Car.");
            }

            ResultSet keys = ps.getGeneratedKeys();
            keys.next();
            int id = keys.getInt(1);  // first column in keys resultset

            return new Car(id, car);
        }
        catch (SQLException ex)
        {
            throw new KajCarExceptions("Unable to insert new Car data.");
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

    @Override
    public Car readName(String carName)
    {
        try (Connection con = cm.getConnection())
        {
            String sql = "SELECT * FROM Car WHERE Name = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, carName);

            ResultSet rs = ps.executeQuery();
            if (rs.next())
            {
                return getOneCar(rs);
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
            String sql = "SELECT * FROM Car WHERE ID = ?";
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
            String sql = "UPDATE car SET Name = ?, KM = ? WHERE ID = ?";
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
            String sql = "UPDATE car SET Name = ?, KM = ?, DepId = ?, CatId = ? WHERE ID = ?";
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

}
