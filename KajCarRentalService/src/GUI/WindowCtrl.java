/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author notandi
 */
public abstract class WindowCtrl extends javax.swing.JFrame
{

public void WindowCtrl()
{
    setResizable(false);
    setLocationRelativeTo(null);
    WindowCloseEvent();
}

public void WindowCloseEvent()
{

    addWindowListener(new WindowAdapter()
    {
    @Override
    public void windowClosing(WindowEvent e)
    {
        doWindowClosing(e);
    }

    });
}

private void doWindowClosing(WindowEvent e)
{

    //System.exit(0);
    int option = JOptionPane.showConfirmDialog(this, "Do you really want to close ?");
    if (option == JOptionPane.YES_OPTION)
    {

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);      // shuts the application down when the last window closes.
    }
    else if (option == JOptionPane.NO_OPTION)
    {
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
    }

}

}
