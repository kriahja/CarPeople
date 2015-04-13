/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import BE.Car;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author notandi
 */
public class CarTableModel extends AbstractTableModel
{

    public static final int NAME_COLUMN = 0;
    public static final int KM_COLUMN = 1;
    

    private final String[] headers =
    {
        "Name", "Km"
    };

    private final Class[] columnTypes =
    {
        String.class, Integer.class
    };
    
    private List<Car> cars;
   
    
    public CarTableModel(List<Car> initialCars)
    {
        cars = initialCars;

    }

    public CarTableModel()
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

    public void setCarList(List<Car> songList)
    {
        cars = songList;
    } 
}
