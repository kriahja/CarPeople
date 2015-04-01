/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL.SQL;

import BE.Controller.EntityCtrl;
import DAL.DBConnectionManager;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author notandi
 */
public class SQLObjectIdRepository
{

    private final DBConnectionManager cm;

    private static SQLObjectIdRepository instance = null;

    public static SQLObjectIdRepository getInstance() throws IOException
    {
        if (instance == null)
        {
            instance = new SQLObjectIdRepository();
        }
        return instance;
    }
    
    private SQLObjectIdRepository() throws IOException
    {
        cm = DBConnectionManager.getInstance();
    }
    
    private EntityCtrl getOneObject (ResultSet rs) throws SQLException
    {
        
        int carId = rs.getInt("ID");
        int depId = rs.getInt("ID");
        int catId = rs.getInt("ID");
        
        int customerId = rs.getInt("ID");
        int rentId = rs.getInt("ID");
        int typeId = rs.getInt("ID");
        
        int insuranceId = rs.getInt("ID");
        
        EntityCtrl ec = new EntityCtrl();
        
        return ec;
    }
}
