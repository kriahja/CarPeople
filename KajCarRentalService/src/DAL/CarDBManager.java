/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import BE.Car;
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
public class CarDBManager {
    
    
    private final DBConnectionManager cm;

    private static CarDBManager instance = null;

    public static CarDBManager getInstance() throws IOException {
        if (instance == null) {
            instance = new CarDBManager();
        }
        return instance;
    }

    CarDBManager() throws IOException {
        cm = DBConnectionManager.getInstance();
    }

    private Car getOneCar(ResultSet rs) throws SQLException {
        //int carId = rs.getInt("ID");
        String carName = rs.getString("Name");
        int depId = rs.getInt("DepId");
        int catId = rs.getInt("CatId");
        int km = rs.getInt("KM");
        boolean isDamaged = rs.getBoolean("IsDamaged");
        boolean isFull = rs.getBoolean("IsFull");
        boolean isFixed = rs.getBoolean("IsFixed");

      Car car = new Car(carName, depId, catId, km, isDamaged, isFull, isFixed);
      
        return car;

    }

    /**
     * @param carId
     * @return
     */
    public Car getById(int carId) throws SQLException {
        try (Connection con = cm.getConnection()) {
            String sql = "SELECT * FROM Car WHERE ID = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, carId);

            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
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
    public Car getByName(String carName) throws SQLException {
        try (Connection con = cm.getConnection()) {
            String sql = "SELECT * FROM Car WHERE Name = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, carName);

            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return getOneCar(rs);
            }
        }
        return null;
    }

    public ArrayList<Car> getAll() throws SQLException {
        try (Connection con = cm.getConnection()) {
            ArrayList<Car> carList = new ArrayList<>();
            String sql = "Select * from Car";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                Car car = getOneCar(rs);
                carList.add(car);
            }
            return carList;
        }
    }
}
