/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL.DB;

import BE.Insurance;
import BLL.Exceptions.KajCarExceptions;
import DAL.DBConnectionManager;
import DAL.ICRUDmanager;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author a.tamas
 */
public class InsurranceDBManager implements ICRUDmanager<Insurance> {

    private final DBConnectionManager cm;

    private static InsurranceDBManager instance = null;

    public static InsurranceDBManager getInstance() throws IOException {
        if (instance == null) {
            instance = new InsurranceDBManager();
        }
        return instance;
    }

    private InsurranceDBManager() throws IOException {
        cm = DBConnectionManager.getInstance();
    }

    @Override
    public Insurance create(Insurance t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Insurance> readAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Insurance readId(int id) {
        try (Connection con = cm.getConnection()) {
            String sql = "SELECT * FROM Insurance WHERE ID = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return getOneInsurance(rs);
            }
        } catch (SQLException ex) {
            throw new KajCarExceptions("Unable to read INsurance.");
        }
        return null;
    }

    @Override
    public void update(Insurance t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    private Insurance getOneInsurance(ResultSet rs) throws SQLException
    {

        String type = rs.getString("Type");
      
//        String depName = rs.getString("Name");

        Insurance ins = new Insurance(type);

        return ins;
    }

}
