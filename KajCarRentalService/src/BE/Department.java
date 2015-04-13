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
public class Department extends EntityID
{
    private String name;

    public Department(String name)
    {
        this.name = name;
    }
    
    public Department(int id, String name)
    {
        setId(id);
        this.name = name;
    }
    
    public Department(int id, Department dep)
    {
        this(id, dep.getName());
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }
}
