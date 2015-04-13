/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.awt.Component;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JFormattedTextField;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;

/**
 *
 * @author agnarsdottir
 */
public class StartEndDate implements TableCellRenderer
{

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column)
    {
      JFormattedTextField ft = new JFormattedTextField(new SimpleDateFormat("dd.MM.yyyy"));
        ft.setValue((Date) value);
        return ft;
    }
    
}
