/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.CreditCard;

import BE.CreditCard;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author notandi
 */
public class CreditCardTableModel extends AbstractTableModel
{

    // Instance fields containing the creditCards to show in the table.

    private ArrayList<CreditCard> creditCards;

    /**
     * Creates a new CreditCardTableModel instance with the creditCards from the
     * given initial list allEmploees.
     *
     * @param allCreditCards The initial list of creditCards.
     */
    public CreditCardTableModel(ArrayList<CreditCard> allCreditCards)
    {
        // TO DO
    }

    @Override
    public int getRowCount()
    {
        // TO DO
        return 0; // DUMMY VALUE
    }

    @Override
    public int getColumnCount()
    {
        // TO DO
        return 1; // DUMMY VALUE
    }

    @Override
    public Object getValueAt(int row, int col)
    {
        // TO DO
        return null; // DUMMY VALUE
    }

    /**
     * Sets the content of the table model to the given list of creditCards.
     *
     * @param empList the list of creditCards to show in the JTable.
     */
    public void setCreditCardList(ArrayList<CreditCard> empList)
    {
        // TO DO
    }

    /**
     * Return the creditCard instance from the table model with the given row
     * index.
     *
     * @param row the index for the creditCard in the creditCards list.
     * @return the creditCard at the given row index.
     */
    public CreditCard getCreditCardByRow(int row)
    {
        // TO DO
        return null; // DUMMY VALUE
    }
}
