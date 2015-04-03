/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.Customer;

import java.awt.Color;
import java.awt.Component;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author notandi
 */
public class CustomerTable extends JTable
{

    public CustomerTable(CustomerTableModel model)
    {
        super(model);
        setRowSorter(new TableRowSorter(model));
    }

    @Override
    public Component prepareRenderer(TableCellRenderer tcr, int row, int col)
    {
        Component c = super.prepareRenderer(tcr, row, col); //To change body of generated methods, choose Tools | Templates.       
        if (!isRowSelected(row))
        {   // every second row is painted light grey with default fore-ground color.
            c.setBackground(row % 2 == 0 ? Color.LIGHT_GRAY : getBackground());
            c.setForeground(getForeground());
        }
        else // selected row is painted green
        {
            c.setBackground(Color.green);
            c.setForeground(Color.BLACK);
        }
        return c;
    }

}
