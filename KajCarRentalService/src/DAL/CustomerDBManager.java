/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import BE.Customer;
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
public class CustomerDBManager {
    
    private final DBConnectionManager cm;

    private static CustomerDBManager instance = null;

    public static CustomerDBManager getInstance() throws IOException {
        if (instance == null) {
            instance = new CustomerDBManager();
        }
        return instance;
    }

    CustomerDBManager() throws IOException {
        cm = DBConnectionManager.getInstance();
    }

    private Customer getOneCustomer(ResultSet rs) throws SQLException {
        //int customerId = rs.getInt("ID");
        String customerName = rs.getString("Name");
        String address = rs.getString("Address");
        int creditCardId = rs.getInt("CreditCardId");
        int rentId = rs.getInt("RentId");
        String driversLicenseNo = rs.getString("DriverLicenseNo");
        int typeId = rs.getInt("TypeId");

      Customer cust = new Customer(customerName, address, creditCardId, rentId, driversLicenseNo, typeId);
      
        return cust;

    }

    /**
     * @param customerId
     * @return
     */
    public Customer getById(int customerId) throws SQLException {
        try (Connection con = cm.getConnection()) {
            String sql = "SELECT * FROM Customer WHERE ID = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, customerId);

            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return getOneCustomer(rs);
            }
        }
        return null;
    }

    /**
     *
     * @param customerName
     * @return
     * @throws SQLException
     */
    public Customer getByName(String customerName) throws SQLException {
        try (Connection con = cm.getConnection()) {
            String sql = "SELECT * FROM Customer WHERE Name = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, customerName);

            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return getOneCustomer(rs);
            }
        }
        return null;
    }

    public ArrayList<Customer> getAll() throws SQLException {
        try (Connection con = cm.getConnection()) {
            ArrayList<Customer> custList = new ArrayList<>();
            String sql = "Select * from Customer";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                Customer cust = getOneCustomer(rs);
                custList.add(cust);
            }
            return custList;
        }
    }
    
    
    public Customer addCustomer(Customer cus) throws SQLException
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

            int affectedRows = ps.executeUpdate();
            if (affectedRows == 0)
            {
                throw new SQLException("Unable to add Customer.");
            }

            ResultSet keys = ps.getGeneratedKeys();
            keys.next();
            int id = keys.getInt(1);  // first column in keys resultset

            return new Customer(id, cus);
        }
    }
    
}
