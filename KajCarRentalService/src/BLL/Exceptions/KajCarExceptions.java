/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BLL.Exceptions;

/**
 *
 * @author a.tamas
 */
public class KajCarExceptions extends RuntimeException {
    
     public KajCarExceptions(String message)
    {
        super(message);
    }
}