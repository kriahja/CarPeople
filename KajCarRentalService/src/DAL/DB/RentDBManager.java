/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL.DB;

import BE.Rent;
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
 * @author ZALI
 */
public class RentDBManager implements ICRUDmanager<Rent> 
{
    private final DBConnectionManager cm;
    private static RentDBManager instance = null;
    
    public RentDBManager() throws IOException {
       cm = DBConnectionManager.getInstance();
    }
    
    public static RentDBManager getInstance() throws IOException
    {
        if (instance == null)
        {
            instance = new RentDBManager();
        }
        return instance;
    }
    
     private Rent getOneRent(ResultSet rs) throws SQLException
    {

        int startDate = rs.getInt("StartDate");
        int endDate = rs.getInt("EndDate");

        Rent rent = new Rent(startDate, endDate);

        return rent;
    }
    
    @Override
    public Rent create(Rent rent) {
        try (Connection con = cm.getConnection())
        {
            String sql = "INSERT INTO Rent(CustId, CarId, InsurranceId, "
                    + "StartDate, EndDate) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(sql,
                    PreparedStatement.RETURN_GENERATED_KEYS);
            ps.setInt(1, rent.getCustomerId());
            ps.setInt(2, rent.getCarId());
            ps.setInt(3, rent.getInsuranceId());
            ps.setInt(4, rent.startDate);
            ps.setInt(4, rent.endDate);

            int affectedRows = ps.executeUpdate();
            if (affectedRows == 0)
            {
                throw new SQLException("Unable to add Car.");
            }

            ResultSet keys = ps.getGeneratedKeys();
            keys.next();
            int id = keys.getInt(1);  // first column in keys resultset

            return new Rent(id, rent);
        }
        catch (SQLException ex)
        {
            throw new KajCarExceptions("Unable to insert new Rent data.");
        }
    }

    @Override
    public List<Rent> readAll() {
        try (Connection con = cm.getConnection())
        {
            ArrayList<Rent> carList = new ArrayList<>();
            String sql = "Select * from Rent";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);

            while (rs.next())
            {
                Rent rent = getOneRent(rs);
                carList.add(rent);
            }
            return carList;
        }
        catch (SQLException ex)
        {

            throw new KajCarExceptions("Unable to read data.");
        }
    }

    @Override
    public Rent readId(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(Rent t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
