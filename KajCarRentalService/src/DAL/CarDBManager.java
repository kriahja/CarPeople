/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import BE.Car;
import BLL.Exceptions.KajCarExceptions;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author a.tamas
 */
public class CarDBManager
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

    public Car getOneCar(ResultSet rs) throws SQLException
    {
        //int carId = rs.getInt("ID");
        String carName = rs.getString("Name");
        int km = rs.getInt("KM");
        

        Car car = new Car(carName, km);

        return car;

    }

    /**
     * @param carId
     * @return
     */
    public Car getById(int carId) throws SQLException
    {
        try (Connection con = cm.getConnection())
        {
            String sql = "SELECT * FROM Car WHERE ID = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, carId);

            ResultSet rs = ps.executeQuery();
            if (rs.next())
            {
                return getOneCar(rs);
            }
        }
        return null;
    }

    /**
     *
     * @param carName
     * @return
     * @throws SQLException
     */
    public Car getByName(String carName) throws SQLException
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
        return null;
    }

    public ArrayList<Car> getAll() throws SQLException
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
    }

    public Car addCar(Car car) throws SQLException
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
    }

    public void removeCar(int carId) throws SQLException
    {
        {
            try (Connection con = cm.getConnection())
            {
                String sql = "DELETE FROM Car WHERE ID = ?";
                PreparedStatement ps = con.prepareStatement(sql);
                ps.setInt(1, carId);

                int affectedRows = ps.executeUpdate();
                if (affectedRows == 0)
                {
                    throw new SQLException("Unable to remove Car.");
                }
            }
        }
    }

    public void updateCar(Car car) throws SQLException
    {
        try (Connection con = cm.getConnection())
        {
            String sql = "UPDATE car SET Name = ?, DepId = ?, CatId = ? WHERE ID = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, car.getName());
            ps.setInt(2, car.getDepId());

            ps.setInt(3, car.getCatId());
            ps.setInt(4, car.getId());

            int affectedRows = ps.executeUpdate();
            if (affectedRows == 0)
            {
                throw new KajCarExceptions("Unable to update car.");
            }
        }
    }
}
