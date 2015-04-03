/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import static com.sun.java.accessibility.util.AWTEventMonitor.addWindowListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author notandi
 */
public class WindowCtrl extends javax.swing.JFrame
{

    private static WindowCtrl instance = null;

    private WindowCtrl()
    {

        WindowClose();
    }

    private void WindowClose()
    {

    }

    public static WindowCtrl getInstance()
    {
        if (instance == null)
        {
            instance = new WindowCtrl();
        }
        return instance;
    }


}
