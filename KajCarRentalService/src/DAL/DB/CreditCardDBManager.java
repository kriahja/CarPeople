/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL.DB;

import BE.CreditCard;
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

/**
 *
 * @author notandi
 */
public class CreditCardDBManager implements ICRUDmanager<CreditCard>
{

    private final DBConnectionManager cm;

    private static CreditCardDBManager instance = null;

    public static CreditCardDBManager getInstance() throws IOException
    {
        if (instance == null)
        {
            instance = new CreditCardDBManager();
        }
        return instance;
    }

    private CreditCardDBManager() throws IOException
    {
        cm = DBConnectionManager.getInstance();
    }

    private CreditCard getOneCreditCard(ResultSet rs) throws SQLException
    {
        int cardNumber = rs.getInt("CardNum");
        int regNumber = rs.getInt("RegNum");
        int exp = rs.getInt("Exp");

        CreditCard credit = new CreditCard(cardNumber, regNumber, exp);
        return credit;
    }

    @Override
    public CreditCard create(CreditCard credit)
    {
        try (Connection con = cm.getConnection())
        {
            String sql = "INSERT INTO (CardNum, RegNum, Exp) VALUES (?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(sql,
                    PreparedStatement.RETURN_GENERATED_KEYS);

            ps.setInt(1, credit.getCardNumber());
            ps.setInt(2, credit.getRegNumber());
            ps.setInt(3, credit.getExp());

            ResultSet rs = ps.executeQuery();

            ResultSet keys = ps.getGeneratedKeys();
            keys.next();
            int id = keys.getInt(1);  // first column in keys resultset

            return new CreditCard(id, credit);
        }
        catch (SQLException ex)
        {
            throw new KajCarExceptions("Unable to create Credit Card");
        }
    }

    @Override
    public ArrayList<CreditCard> readAll()
    {
        try (Connection con = cm.getConnection())
        {
            ArrayList<CreditCard> creditList = new ArrayList<>();
            String sql = "Select * from CreditCard";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);

            while (rs.next())
            {
                CreditCard credit = getOneCreditCard(rs);
                creditList.add(credit);
            }
            return creditList;
        }
        catch (SQLException ex)
        {
            throw new KajCarExceptions("Unable to read all Credit Card data.");
        }

    }

    @Override
    public CreditCard readId(int id)
    {
        try (Connection con = cm.getConnection())
        {
            String sql = "SELECT * FROM CreditCard WHERE ID = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();
            if (rs.next())
            {
                return getOneCreditCard(rs);
            }
        }
        catch (SQLException ex)
        {
            throw new KajCarExceptions("Unable to read all Credit Card data.");
        }
        return null;
    }

    @Override
    public void update(CreditCard credit)
    {
        try (Connection con = cm.getConnection())
        {
            String sql = "UPDATE CreditCard SET CreditNum = ?, RegNum = ?"
                    + "Exp = ?"
                    + "WHERE ID = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, credit.getCardNumber());
            ps.setInt(2, credit.getRegNumber());
            ps.setInt(3, credit.getExp());

            ps.executeUpdate();
        }
        catch (SQLException ex)
        {
            throw new KajCarExceptions("Unable to update Credit Card data.");
        }
    }

    @Override
    public void delete(int id)
    {
        try (Connection con = cm.getConnection())
        {
            String sql = "DELETE FROM CreditCard WHERE ID = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);

            ps.executeUpdate();

        }
        catch (SQLException ex)
        {
            throw new KajCarExceptions("Unable to delete Credit Card.");
        }
    }

    public ArrayList<CreditCard> readCardNumber(int cardNumber)
    {
        try (Connection con = cm.getConnection())
        {
            ArrayList<CreditCard> creditList = new ArrayList<>();
            String sql = "SELECT * FROM CreditCard WHERE CreditNum = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, cardNumber);

            ResultSet rs = ps.executeQuery();
            if (rs.next())
            {
                CreditCard credit = getOneCreditCard(rs);
                creditList.add(credit);

            }
            return creditList;
        }
        catch (SQLException ex)
        {
            throw new KajCarExceptions("Unable to read customer name.");
        }
    }

    public ArrayList<CreditCard> readRegNumber(int regNumber)
    {
        try (Connection con = cm.getConnection())
        {
            ArrayList<CreditCard> creditList = new ArrayList<>();
            String sql = "SELECT * FROM CreditCard WHERE RegNum = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, regNumber);

            ResultSet rs = ps.executeQuery();
            if (rs.next())
            {
                CreditCard credit = getOneCreditCard(rs);
                creditList.add(credit);

            }
            return creditList;
        }
        catch (SQLException ex)
        {
            throw new KajCarExceptions("Unable to read customer name.");
        }
    }

    public ArrayList<CreditCard> readExp(int exp)
    {
        try (Connection con = cm.getConnection())
        {
            ArrayList<CreditCard> creditList = new ArrayList<>();
            String sql = "SELECT * FROM CreditCard WHERE Exp = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, exp);

            ResultSet rs = ps.executeQuery();
            if (rs.next())
            {
                CreditCard credit = getOneCreditCard(rs);
                creditList.add(credit);

            }
            return creditList;
        }
        catch (SQLException ex)
        {
            throw new KajCarExceptions("Unable to read customer name.");
        }
    }
}
