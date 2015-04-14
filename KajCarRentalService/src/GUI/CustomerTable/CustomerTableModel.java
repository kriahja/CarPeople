/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.CustomerTable;

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
    public static final int DRIVERS_COLUMN = 2;
    
    private final String[] headers =
    {
        "Name", "Address", "Drivers License"
    };

    private final Class[] columnTypes =
    {
        String.class, String.class, String.class
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
            case DRIVERS_COLUMN:
                return c.getDriversLicenceNo();
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
