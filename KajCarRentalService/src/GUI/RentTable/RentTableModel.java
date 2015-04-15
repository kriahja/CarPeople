/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.RentTable;

import BE.Rent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author notandi
 */
public class RentTableModel extends AbstractTableModel
{

    public static final int RENTID_COLUMN = 0;
    public static final int CUSTOMER_COLUMN = 1;
    public static final int CAR_COLUMN = 2;
    public static final int INSURE_COLUMN = 3;
//    public static final int START_COLUMN = 4;
//    public static final int END_COLUMN = 5;

    private final String[] headers =
    {
        "Rent ID", "Customer Name", "Car Name", "Insurance"
    };

    private final Class[] columnTypes =
    {
        String.class, String.class, String.class, String.class, Integer.class, Integer.class
    };

    private List<Rent> rents;

    public RentTableModel(List<Rent> initialRents)
    {
        rents = initialRents;
    }

    public RentTableModel()
    {
        rents = new ArrayList<>();
    }

    @Override
    public int getRowCount()
    {
        return rents.size();
    }

    @Override
    public int getColumnCount()
    {
        return headers.length;
    }

    @Override
    public Object getValueAt(int row, int col)
    {
        Rent r = rents.get(row);
        switch (col)
        {
            case RENTID_COLUMN:
                return r.getId();
            case CUSTOMER_COLUMN:
                return r.getCustName();
            case CAR_COLUMN:
                return r.getCarName();
            case INSURE_COLUMN:
                return r.getInsureType();
//            case START_COLUMN:
//                return r.getStartDate();
//            case END_COLUMN:
//                return r.getEndDate();
        }
        return null;
    }
    
    @Override
    public String getColumnName(int col)
    {
        return headers[col];
    }

    @Override
    public Class<?> getColumnClass(int col)
    {
        return columnTypes[col];
    }

    public Rent getRent(int row)
    {
        return rents.get(row);
    }

    public void setRentList(List<Rent> rentList)
    {
        rents = rentList;
        fireTableDataChanged();
    }     

}
