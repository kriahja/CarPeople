/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import BE.Controller.*;
import java.util.List;

/**
 *
 * @author notandi
 * @param <T>
 */
public interface ICRUDrepository<T extends IEntityCtrl>
{

    public T create(T t);

    public List<T> readAll();

    public T readName(String name);
    
    //public T readId(int id);

    public void update(T t);

    public void delete(int id);
}
