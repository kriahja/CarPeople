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
    private Insurance ins;

    private String custName;
    private String carName;
    private String insureType;

    private int custId;
    private int carId;
    private int insureId;

    private int startDate;
    private int endDate;
    

    public Rent(int startDate, int endDate)
    {
        this.startDate = startDate;
        this.endDate = endDate;
    }
    
    public Rent(Car car, Customer cust, Insurance ins)
    {
        this.car = car;
        carId = car.getId();
        this.cust = cust;
        custId = cust.getId();
        this.ins = ins;
        insureId = ins.getId();
    }

    public Rent(int id, int startDate, int endDate)
    {
        setId(id);
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public Rent(int id, int custId, int carId, int insureId, int startDate, int endDate)
    {
        setId(id);
        this.custId = custId;
        this.carId = carId;
        this.insureId = insureId;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public Rent(int id, Rent rent)
    {
        this(id, rent.getCustId(), rent.getCarId(), rent.getInsureId(), rent.getStartDate(), rent.getEndDate());
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
        return custName;
    }

    /**
     * @param custName the custName to set
     */
    public void setCustName(String custName)
    {
        this.custName = custName;
    }

    /**
     * @return the carName
     */
    public String getCarName()
    {
        return carName;
    }

    /**
     * @param carName the carName to set
     */
    public void setCarName(String carName)
    {
        this.carName = carName;
    }

    /**
     * @return the insureType
     */
    public String getInsureType()
    {
        return insureType;
    }

    /**
     * @param insureType the insureType to set
     */
    public void setInsureType(String insureType)
    {
        this.insureType = insureType;
    }

    /**
     * @return the custId
     */
    public int getCustId()
    {
        return custId;
    }

    /**
     * @return the carId
     */
    public int getCarId()
    {
        return carId;
    }

    /**
     * @return the insureId
     */
    public int getInsureId()
    {
        return insureId;
    }

}
