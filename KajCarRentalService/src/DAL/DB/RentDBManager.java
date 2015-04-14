/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL.DB;

import BE.Customer;
import BE.Insurance;
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
    Customer cust;
    Insurance insurance;

    public RentDBManager() throws IOException
    {
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

        int id = rs.getInt("ID");
        int startDate = rs.getInt("StartDate");
        int endDate = rs.getInt("EndDate");

        Rent rent = new Rent(id, startDate, endDate);

        return rent;
    }

    @Override
    public Rent create(Rent rent)
    {
        try (Connection con = cm.getConnection())
        {

            String sql = "INSERT INTO Rent(CustId, CarId, InsurranceId, "
                    + " VALUES (?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(sql,
                    PreparedStatement.RETURN_GENERATED_KEYS);
            ps.setInt(1, rent.getCustId());
            ps.setInt(2, rent.getCarId());
            ps.setInt(3, rent.getInsureId());

            int affectedRows = ps.executeUpdate();
            if (affectedRows == 0)
            {
                throw new SQLException("Unable to add Rent.");
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
    public List<Rent> readAll()
    {
        try (Connection con = cm.getConnection())
        {
            ArrayList<Rent> rentList = new ArrayList<>();
            String sql = "Select * FROM Rent";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);

            while (rs.next())
            {
                Rent rent = getOneRent(rs);
                rentList.add(rent);
            }
            return rentList;
        }
        catch (SQLException ex)
        {

            throw new KajCarExceptions("Unable to read data.");
        }
    }

    @Override
    public Rent readId(int id)
    {
        try (Connection con = cm.getConnection())
        {
            String sql = "SELECT Rent.ID, Customer.Name, Car.Name, Insurance.Type, Rent.StartDate, Rent.EndDate"
                    + "FROM Rent"
                    + "INNER JOIN Customer ON Rent.CustId = Customer.ID "
                    + "INNER JOIN Car ON Rent.CarId = Car.ID"
                    + "INNER JOIN Insurance ON Rent.InsuranceId = Insurance.ID";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();
            if (rs.next())
            {
                return getOneRent(rs);
            }
        }
        catch (SQLException ex)
        {
            throw new KajCarExceptions("Unable to read Rent id.");
        }
        return null;
    }

    @Override
    public void update(Rent rent)
    {
        try (Connection con = cm.getConnection())
        {
            String sql = "UPDATE rent SET  CustId = ?, CarId = ?, InsurranceId = ?, StartDate = ?, EndDate = ? WHERE ID = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, rent.getStartDate());
            ps.setInt(2, rent.getEndDate());

            ps.executeUpdate();
        }
        catch (SQLException ex)
        {
            throw new KajCarExceptions("Unable to update rent data.");
        }
    }

    @Override
    public void delete(int id)
    {
        try (Connection con = cm.getConnection())
        {
            String sql = "DELETE FROM Rent WHERE ID = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);

            ps.executeUpdate();

        }
        catch (SQLException ex)
        {
            throw new KajCarExceptions("Unable to remove Rent.");
        }

    }
    /*
     public Rent create(Rent rent) throws SQLException
     {
     try (Connection con = cm.getConnection())
     {
     String sql = "INSERT INTO Rent(CustId, RentId, InsurranceId, "
     + "StartDate, EndDate) VALUES (?, ?, ?, ?, ?)";
     PreparedStatement ps = con.prepareStatement(sql,
     PreparedStatement.RETURN_GENERATED_KEYS);
     ps.setInt(1, rent.getCustomerId());
     ps.setInt(2, rent.getRentId());
     ps.setInt(3, rent.getInsuranceId());
     ps.setInt(4, rent.startDate);
     ps.setInt(4, rent.endDate);

     int affectedRows = ps.executeUpdate();
     if (affectedRows == 0)
     {
     throw new SQLException("Unable to add Rent.");
     }

     ResultSet keys = ps.getGeneratedKeys();
     keys.next();
     int id = keys.getInt(1);  // first column in keys resultset

     return new Rent(id, rent);
     }
     }
     */

    public ArrayList<Rent> readCatId(int id)
    {
        try (Connection con = cm.getConnection())
        {
            ArrayList<Rent> rentList = new ArrayList<>();
            String sql = "SELECT * FROM Rent WHERE CatId = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();
            if (rs.next())
            {
                Rent rent = getOneRent(rs);
                rentList.add(rent);
            }

            return rentList;
        }
        catch (SQLException ex)
        {
            throw new KajCarExceptions("Unable to read rent catid.");
        }

    }

    public ArrayList<Rent> getCarId(int id)
    {
        try (Connection con = cm.getConnection())
        {
            ArrayList<Rent> rentList = new ArrayList<>();
            String sql = "SELECT * FROM Rent WHERE CarId = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();
            if (rs.next())
            {
                Rent rent = getOneRent(rs);
                rentList.add(rent);
            }

            return rentList;
        }
        catch (SQLException ex)
        {
            throw new KajCarExceptions("Unable to read rent carid.");
        }

    }

    public ArrayList<Rent> getByInsId(int id)
    {
        try (Connection con = cm.getConnection())
        {
            ArrayList<Rent> rentList = new ArrayList<>();
            String sql = "SELECT * FROM Rent WHERE InsuranceId = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();
            if (rs.next())
            {
                Rent rent = getOneRent(rs);
                rentList.add(rent);
            }

            return rentList;
        }
        catch (SQLException ex)
        {
            throw new KajCarExceptions("Unable to read rent insuranceid.");
        }

    }

    public ArrayList<Rent> getByStartDate(int id)
    {
        try (Connection con = cm.getConnection())
        {
            ArrayList<Rent> rentList = new ArrayList<>();
            String sql = "SELECT * FROM Rent WHERE StartDate = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();
            if (rs.next())
            {
                Rent rent = getOneRent(rs);
                rentList.add(rent);
            }

            return rentList;
        }
        catch (SQLException ex)
        {
            throw new KajCarExceptions("Unable to read rent start date.");
        }

    }

    public ArrayList<Rent> getByEndDate(int id)
    {
        try (Connection con = cm.getConnection())
        {
            ArrayList<Rent> rentList = new ArrayList<>();
            String sql = "SELECT * FROM Rent WHERE EndDate = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();
            if (rs.next())
            {
                Rent rent = getOneRent(rs);
                rentList.add(rent);
            }

            return rentList;
        }
        catch (SQLException ex)
        {
            throw new KajCarExceptions("Unable to read rent end date.");
        }

    }

}
