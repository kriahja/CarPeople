
package BE;

import BE.Controller.*;
import BLL.RentManager;

/**
 *
 * @author ZALI
 */
public class Rent extends EntityCtrl {
    public int startDate;
    public int endDate;

    public Rent(int id, Rent rent) {
        RentManager.getInstance().getById(id);
         try
        {
            rent.clone();
        }
        catch (CloneNotSupportedException ex)
        {
            ex.getMessage();
        }
    }
    
    

    public int getStartDate() {
        return startDate;
    }

    public void setStartDate(int startDate) {
        this.startDate = startDate;
    }

    public int getEndDate() {
        return endDate;
    }

    public void setEndDate(int endDate) {
        this.endDate = endDate;
    }
    
    
    
}
