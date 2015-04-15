/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.CarTable;

import BE.Car;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author notandi
 */
public class CarCheckTableModel extends AbstractTableModel
{

    public static final int NAME_COLUMN = 0;
    public static final int KM_COLUMN = 1;
    public static final int TANK_COLUMN = 2;
    public static final int DAMAGED_COLUMN = 3;
    public static final int REPAIRED_COLUMN = 4;
    

    private final String[] headers =
    {
        "Name", "Km", "Full Fuel", "Damaged", "Repaired"
    };

    private final Class[] columnTypes =
    {
        String.class, Integer.class, Boolean.class, Boolean.class, Boolean.class 
    };
    
    private List<Car> cars;
   
    
    public CarCheckTableModel(List<Car> initialCars)
    {
        cars = initialCars;

    }

    public CarCheckTableModel()
    {
        cars = new ArrayList<>();
    }

    @Override
    public int getRowCount()
    {
        return cars.size();
    }

    @Override
    public int getColumnCount()
    {
        return headers.length;
    }

    @Override
    public Object getValueAt(int row, int col)
    {
        Car c = cars.get(row);
        switch (col)
        {
            case NAME_COLUMN:
                return c.getName();
            case KM_COLUMN:
                return c.getKm();
            case TANK_COLUMN:
                return c.isIsFull();
            case DAMAGED_COLUMN:
                return c.isIsDamaged();
            case REPAIRED_COLUMN:
                return c.isIsFixed();
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

    public Car getCar(int row)
    {
        return cars.get(row);
    }

    public void setCarList(List<Car> carList)
    {
        cars = carList;
        fireTableDataChanged();
    } 
}
