/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import BE.Controller.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author notandi
 * @param <T>
 */
public abstract class AbstractMockRepository<T extends EntityCtrl> implements ICRUDrepository<T>
{

    private List<T> list;
    static int id = 0;

    public AbstractMockRepository()
    {
        list = new ArrayList<>();
        
    }

    @Override
    public T create(T t)
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    private int getNextAvailableId()
    {
        return ++id;
    }

    @Override
    public List<T> readAll()
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public T read(int id)
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(T t)
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(int id)
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
