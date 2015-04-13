package BE;

import BE.Controller.*;
import BLL.RentManager;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 *
 * @author ZALI
 */
public class Rent extends EntityID
{
    private static DateFormat df = new SimpleDateFormat("dd.MM.yyyy");

    private Calendar startDate;
    private Calendar endDate;
    private int id;
     

    public Rent(  String startDate, String endDate)
    {
        //this.startDate = startDate;
        //this.endDate = endDate;
        
    
    this.startDate = Calendar.getInstance();
        try
        {
            this.startDate.setTime(df.parse(startDate));
        }
        catch (Exception ex)
        {
            this.startDate = null;
        }
         
    this.endDate = Calendar.getInstance();
        try
        {
            this.endDate.setTime(df.parse(endDate));
        }
        catch (Exception ex)
        {
            this.endDate = null;
        }
    }
    public Rent(int id, String startDate, String endDate)
    {
        setId(id);
        this.startDate = Calendar.getInstance();
        try
        {
            this.startDate.setTime(df.parse(startDate));
        }
        catch (Exception ex)
        {
            this.startDate = null;
        }
         
    this.endDate = Calendar.getInstance();
        try
        {
            this.endDate.setTime(df.parse(endDate));
        }
        catch (Exception ex)
        {
            this.endDate = null;
        }
    }
    
    

//    public Rent(int id, Rent rent)
//    {
//        this(id, rent.getStartDate(), rent.getEndDate());
//    }

    /**
     * @return the startDate
     */
    public Calendar getStartDate()
    {
        return startDate;
    }

    /**
     * @param startDate the startDate to set
     */
//    public void setStartDate(Calendar startDate)
//    {
//        this.startDate = startDate;
//    }

    /**
     * @return the endDate
     */
    public Calendar getEndDate()
    {
        return endDate;
    }

    /**
     * @param endDate the endDate to set
     */
//    public Calendar setEndDate()
//    {
//       return endDate;
//    }

    /**
     * @return the id
     */
    public int getId()
    {
        return id;
    }
    
    @Override
    public String toString()
    {
        String sd = df.format(startDate.getTime());
        String ed = df.format(endDate.getTime());
        return String.format("%4d %10s %8.2f %s", id, sd, ed);
    }
}
