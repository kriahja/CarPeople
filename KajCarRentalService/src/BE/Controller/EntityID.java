/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BE.Controller;

/**
 *
 * @author notandi
 */
public class EntityID implements IEntityID
{

    //  OBJECT ID
    private int id;

    @Override
    public int getId()
    {
        return id;
    }

    @Override
    public void setId(int id)
    {
        this.id = id;
    }

}
