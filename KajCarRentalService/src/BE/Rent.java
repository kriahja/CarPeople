package BE;

import BE.Controller.*;

/**
 *
 * @author ZALI
 */
public class Rent extends EntityID
{

    private Customer cust;
    private Car car;
    private Insurance insure;

    
    private String custName;
    private String carName;
    private String insureName;
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

//    public Rent(int id, Rent rent)
//    {
//        this(id, rent.getStartDate(), rent.getEndDate());
//    }
    public Rent(int id, Rent rent)
    {
        this(id, rent.getCustName(), rent.getCarName(), rent.getStartDate(), rent.getEndDate());
    }

    public Rent(int id, String custName, String carName, int startDate, int endDate)
    {
        setId(id);
        this.custName = custName;
        this.carName = carName;
        this.startDate = startDate;
        this.endDate = endDate;
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

    /**
     * @return the custName
     */
    public String getCustName()
    {
        return custName = cust.getName();
    }

    /**
     * @return the carName
     */
    public String getCarName()
    {
        return carName = car.getName();
    }

}
