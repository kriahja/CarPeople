/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.Customer;

import BE.Customer;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author notandi
 */
public class CustomerTableModel extends AbstractTableModel
{

    public static final int NAME_COLUMN = 0;
    public static final int ADDRESS_COLUMN = 1;
    public static final int DRIVERLICENCENR_COLUMN = 2;
    public static final int RENTID_COLUMN = 4;

    private final String[] headers =
    {
        "Name", "Address", "Drivers Licence nr.", "Creditcard nr.", "Rent ID"
    };
    private final Class[] columnType =
    {
        String.class, String.class, String.class, Integer.class, Integer.class
    };

    private List<Customer> customers;

    public CustomerTableModel(List<Customer> initialCustomers)
    {
        customers = initialCustomers;
    }

    public CustomerTableModel()
    {
        customers = new ArrayList<>();
    }

    @Override
    public int getRowCount()
    {
        return customers.size();
    }

    @Override
    public int getColumnCount()
    {
        return headers.length;
    }

    @Override
    public Object getValueAt(int row, int col)
    {
        Customer c = customers.get(row);
        switch (col)
        {
            case NAME_COLUMN:
                return c.getName();
            case ADDRESS_COLUMN:
                return c.getAddress();
            case DRIVERLICENCENR_COLUMN:
                return c.getDriversLicenceNo();
            case RENTID_COLUMN:
                return c.getRentId();
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
        return columnType[col];
    }
    
    @Override
    public boolean isCellEditable(int row, int col)
    {
        return (col != NAME_COLUMN && col != ADDRESS_COLUMN && col != DRIVERLICENCENR_COLUMN && col != RENTID_COLUMN);
    }
    
    public Customer getCustomer(int row)
    {
        return customers.get(row);
    }
    
    public void setCustomerList(List<Customer> custList)
    {
        customers = custList;
        fireTableDataChanged();
    }
}
