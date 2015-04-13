package BE;

import BE.Controller.*;

/**
 *
 * @author ZALI
 */
public class Rent extends EntityID
{


    private int startDate;
    private int endDate;

    public Rent(int startDate, int endDate)
    {
        this.startDate = startDate;
        this.endDate = endDate;
    }
    
    public Rent(int id, int startDate, int endDate)
    {
        setId(id);
        this.startDate = startDate;
        this.endDate = endDate;
    }
    
    public Rent(int id, Rent rent)
    {
        this(id, rent.getStartDate(), rent.getEndDate());
    }
    

    public int getStartDate()
    {
        return startDate;
    }

    public void setStartDate(int startDate)
    {
        this.startDate = startDate;
    }

    public int getEndDate()
    {
        return endDate;
    }

    public void setEndDate(int endDate)
    {
        this.endDate = endDate;
    }

}
