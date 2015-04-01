/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL.SQL;

import BE.Controller.IEntityCtrl;
import BE.Customer;
import BLL.Exceptions.KajCarExceptions;
import DAL.DBConnectionManager;
import DAL.ICRUDrepository;
import com.microsoft.sqlserver.jdbc.SQLServerException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author notandi
 */
public class SQLCustomerRepository implements ICRUDrepository<Customer>
{

    private final DBConnectionManager cm;

    private static SQLCustomerRepository instance = null;

    public static SQLCustomerRepository getInstance() throws IOException
    {
        if (instance == null)
        {
            instance = new SQLCustomerRepository();
        }
        return instance;
    }

    private SQLCustomerRepository() throws IOException
    {
        cm = DBConnectionManager.getInstance();
    }

    private Customer getOneCustomer(ResultSet rs) throws SQLException
    {
        //int customerId = rs.getInt("ID");
        String customerName = rs.getString("Name");
        String address = rs.getString("Address");
        String driversLicenseNo = rs.getString("DriverLicenseNo");  // SQL name?

        Customer cust = new Customer(customerName, address, driversLicenseNo);

        return cust;

    }

    @Override
    public Customer create(Customer cus)
    {
        try (Connection con = cm.getConnection())
        {
            String sql = "INSERT INTO Customer(Name, Address, CreditCardId, "
                    + "RentId, DriversLicenceNo, TypeId) VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(sql,
                    PreparedStatement.RETURN_GENERATED_KEYS);
            ps.setString(1, cus.getName());
            ps.setString(2, cus.getAddress());
            ps.setInt(3, cus.getCreditCardId());
            ps.setInt(4, cus.getRentId());
            ps.setString(5, cus.getDriversLicenceNo());
            ps.setInt(6, cus.getTypeId());

            ps.executeUpdate();

            ResultSet keys = ps.getGeneratedKeys();
            keys.next();
            int id = keys.getInt(1);  // first column in keys resultset

            return new Customer(id, cus);
        }
        catch (SQLException ex)
        {
            throw new KajCarExceptions("Unable to create Customer");
        }
    }

    @Override
    public List<Customer> readAll()
    {
        try (Connection con = cm.getConnection())
        {
            ArrayList<Customer> custList = new ArrayList<>();
            String sql = "Select * from Customer";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);

            while (rs.next())
            {
                Customer cust = getOneCustomer(rs);
                custList.add(cust);
            }
            return custList;
        }
        catch (SQLException ex)
        {
            throw new KajCarExceptions("Unable to read all Customer data.");
        }
    }

    @Override
    public Customer readName(String customerName)
    {
        try (Connection con = cm.getConnection())
        {
            String sql = "SELECT * FROM Customer WHERE Name = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, customerName);

            ResultSet rs = ps.executeQuery();
            if (rs.next())
            {
                return getOneCustomer(rs);
            }
        }
        catch (SQLException ex)
        {
            throw new KajCarExceptions("Unable to read customer name.");
        }
        return null;
    }

    @Override
    public void update(Customer cus)
    {
        try (Connection con = cm.getConnection())
        {
            String sql = "UPDATE customer SET Name = ?, Address = ?"
                    + ", CreditCardId = ?"
                    + ", RentId = ?, DriversLicenceNo = ?"
                    + ", TypeId = ? WHERE ID = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, cus.getName());
            ps.setString(2, cus.getAddress());

            ps.setInt(3, cus.getCreditCardId());
            ps.setInt(4, cus.getRentId());
            ps.setString(5, cus.getDriversLicenceNo());
            ps.setInt(6, cus.getTypeId());

            ps.executeUpdate();
        }
        catch (SQLException ex)
        {
            throw new KajCarExceptions("Unable to update Customer data.");
        }
    }

    @Override
    public void delete(int id)
    {
        try (Connection con = cm.getConnection())
        {
            String sql = "DELETE FROM Customer WHERE ID = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);

            ps.executeUpdate();

        }
        catch (SQLException ex)
        {
            throw new KajCarExceptions("Unable to delete Customer.");
        }
    }

}
