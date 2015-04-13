/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL.DB;

import BE.Department;
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
public class DepartmentDBManager implements ICRUDmanager<Department>
{

    private final DBConnectionManager cm;

    private static DepartmentDBManager instance = null;

    public static DepartmentDBManager getInstance() throws IOException
    {
        if (instance == null)
        {
            instance = new DepartmentDBManager();
        }
        return instance;
    }

    private DepartmentDBManager() throws IOException
    {
        cm = DBConnectionManager.getInstance();
    }

    private Department getOneDepartment(ResultSet rs) throws SQLException
    {
        String depName = rs.getString("Name");

        Department dep = new Department(depName);

        return dep;
    }

    @Override
    public Department create(Department dep)
    {
        try (Connection con = cm.getConnection())
        {
            String sql = "INSERT INTO Department(Name) VALUES (?)";
            PreparedStatement ps = con.prepareStatement(sql,
                    PreparedStatement.RETURN_GENERATED_KEYS);
            ps.setString(1, dep.getName());

            ResultSet keys = ps.getGeneratedKeys(); //
            keys.next();                            // 
            int id = keys.getInt(1);                // changed here because we want t create a dep not get an existing one

            return new Department(id, dep);                //
        }
        catch (SQLException ex)
        {
            throw new KajCarExceptions("Unable to create new Department data.");
        }
    }

    @Override
    public List<Department> readAll()
    {
        try (Connection con = cm.getConnection())
        {
            ArrayList<Department> depList = new ArrayList<>();
            String sql = "Select * from Department";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);

            while (rs.next())
            {
                Department dep = getOneDepartment(rs);
                depList.add(dep);
            }
            return depList;
        }
        catch (SQLException ex)
        {

            throw new KajCarExceptions("Unable to read all Department data.");
        }
    }

    public Department readName(String depName)
    {
        try (Connection con = cm.getConnection())
        {
            String sql = "SELECT * FROM Department WHERE Name = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, depName);

            ResultSet rs = ps.executeQuery();
            if (rs.next())
            {
                return getOneDepartment(rs);
            }
        }
        catch (SQLException ex)
        {
            throw new KajCarExceptions("Unable to read Department name.");
        }
        return null;
    }

    @Override
    public Department readId(int id)
    {
        try (Connection con = cm.getConnection())
        {
            String sql = "SELECT * FROM Department WHERE ID = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();
            if (rs.next())
            {
                return getOneDepartment(rs);
            }
        }
        catch (SQLException ex)
        {
            throw new KajCarExceptions("Unable to read Department id.");
        }
        return null;
    }

    @Override
    public void update(Department dep)
    {
        try (Connection con = cm.getConnection())
        {
            String sql = "UPDATE Department SET Name = ? WHERE ID = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, dep.getName());

            ps.executeUpdate();
        }
        catch (SQLException ex)
        {
            throw new KajCarExceptions("Unable to update department data.");
        }
    }

    @Override
    public void delete(int id)
    {
        try (Connection con = cm.getConnection())
        {
            String sql = "DELETE FROM Department WHERE ID = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);

            ps.executeUpdate();

        }
        catch (SQLException ex)
        {
            throw new KajCarExceptions("Unable to remove Department.");
        }
    }
}
