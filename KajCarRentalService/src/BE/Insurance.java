/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BE;

import BE.Controller.EntityID;

/**
 *
 * @author notandi
 */
public class Insurance extends EntityID
{
    private String type;

    public Insurance(String type)
    {
        this.type = type;
    }
    
    public Insurance( int id, String type)
    {
        setId(id);
        this.type = type;
    }
    
    public Insurance(int id, Insurance insurance)
    {
        this(id, insurance.getType());
    }

    /**
     * @return the type
     */
    public String getType()
    {
        return type;
    }

    /**
     * @param type the type to set
     */
    public void setType(String type)
    {
        this.type = type;
    }

}
