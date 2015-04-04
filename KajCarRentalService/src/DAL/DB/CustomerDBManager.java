/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL.DB;

import BE.Controller.EntityCtrl;
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
public class CustomerDBManager implements ICRUDmanager<Customer>
{

    private final DBConnectionManager cm;

    private static CustomerDBManager instance = null;

    public static CustomerDBManager getInstance() throws IOException
    {
        if (instance == null)
        {
            instance = new CustomerDBManager();
        }
        return instance;
    }

    private CustomerDBManager() throws IOException
    {
        cm = DBConnectionManager.getInstance();
    }

    private Customer getOneCustomer(ResultSet rs) throws SQLException
    {
        //int customerId = rs.getInt("ID");
        String customerName = rs.getString("Name");
        String address = rs.getString("Address");
        String driversLicenseNo = rs.getString("DriversLicenceNr");  // SQL name?

        Customer cust = new Customer(customerName, address, driversLicenseNo);
        return cust;

    }

    @Override
    public Customer create(Customer cus)
    {
        try (Connection con = cm.getConnection())
        {
            String sql = "INSERT INTO Customer(Name, Address, CreditCardId, "
                    + "RentId, DriversLicenceNr, TypeId) VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(sql,
                    PreparedStatement.RETURN_GENERATED_KEYS);
            ps.setString(1, cus.getName());
            ps.setString(2, cus.getAddress());
            ps.setInt(3, cus.getCreditCardId());
            ps.setInt(4, cus.getRentId());
            ps.setString(5, cus.getDriversLicenceNo());
            ps.setInt(6, cus.getTypeId());

            ResultSet rs = ps.executeQuery();

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
    public Customer readId(int id)
    {
        try (Connection con = cm.getConnection())
        {
            String sql = "SELECT * FROM Customer WHERE ID = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();
            if (rs.next())
            {
                return getOneCustomer(rs);
            }
        }
        catch (SQLException ex)
        {
            throw new KajCarExceptions("Unable to read customer id.");
        }
        return null;
    }

    @Override
    public void update(Customer cus)
    {
        try (Connection con = cm.getConnection())
        {
            String sql = "UPDATE customer SET Name = ?, Address = ?"
                    + "DriversLicenceNo = ?"
                    + "WHERE ID = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, cus.getName());
            ps.setString(2, cus.getAddress());
            ps.setString(3, cus.getDriversLicenceNo());

            ps.executeUpdate();
        }
        catch (SQLException ex)
        {
            throw new KajCarExceptions("Unable to update Customer data.");
        }
    }

    public void advancedUpdate(Customer cus)
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
            throw new KajCarExceptions("Unable to perform adcanced update on Customer data.");
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
    
    public ArrayList<Customer> getByAddress(String address)
    {
        try (Connection con = cm.getConnection())
        {
            ArrayList<Customer> cusList = new ArrayList<>();
            String sql = "SELECT * FROM Customer WHERE Address = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, address);

            ResultSet rs = ps.executeQuery();
            if (rs.next())
            {
                Customer cus = getOneCustomer(rs);
                cusList.add(cus);
            }
            return cusList;
        }
        catch (SQLException ex)
        {
            throw new KajCarExceptions("Unable to read customer name.");
        }
        
    }
    
    public Customer getByDriversLicence(String licence)
    {
        try (Connection con = cm.getConnection())
        {
            String sql = "SELECT * FROM Customer WHERE DriversLicence = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, licence);

            ResultSet rs = ps.executeQuery();
            if (rs.next())
            {
                return getOneCustomer(rs);
            }
        }
        catch (SQLException ex)
        {
            throw new KajCarExceptions("Unable to read customer drivers licence.");
        }
        return null;
    }
    
    public Customer getByCreditCardId(int id)
    {
        try (Connection con = cm.getConnection())
        {
            String sql = "SELECT * FROM Customer WHERE CrediCardId = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();
            if (rs.next())
            {
                return getOneCustomer(rs);
            }
        }
        catch (SQLException ex)
        {
            throw new KajCarExceptions("Unable to read customer Credit card id.");
        }
        return null;
    }

}
