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

    public static final int CARDNUMBER_COLUMN = 0;
    public static final int REGNUMBER_COLUMN = 1;
    public static final int EXP_COLUMN = 2;
    // Instance fields containing the creditCards to show in the table.

    private final String[] headers =
    {
        "Card Number", "Exp", "CVC"
    };

    private final Class[] columnType =
    {
        Integer.class, Integer.class, Integer.class
    };

    private ArrayList<CreditCard> creditCards;

    /**
     * Creates a new CreditCardTableModel instance with the creditCards from the
     * given initial list allEmploees.
     *
     * @param creditCard
     */
    public CreditCardTableModel(ArrayList<CreditCard> creditCard)
    {
        creditCards = creditCard;
    }

    @Override
    public int getRowCount()
    {
        return creditCards.size();
    }

    @Override
    public int getColumnCount()
    {
        return headers.length;
    }

    @Override
    public Object getValueAt(int row, int col)
    {
        CreditCard c = creditCards.get(row);
        switch (col)
        {
            case CARDNUMBER_COLUMN:
                return c.getCardNumber();
            case REGNUMBER_COLUMN:
                return c.getRegNumber();
            case EXP_COLUMN:
                return c.getExp();
        }
        return null;
    }

    /**
     * Sets the content of the table model to the given list of creditCards.
     *
     * @param creditList
     */
    public void setCreditCardList(ArrayList<CreditCard> creditList)
    {
        creditCards = creditList;
        fireTableDataChanged();
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
        return creditCards.get(row);
    }
}
