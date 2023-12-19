/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.io.Serializable;
import java.util.List;

/**
 *
 * @author Bonheur
 * @param <T>
 */
public interface IgenericDao<T extends Serializable> {
    public void create( T x);
    public void delete(T x);
    public void update(T x);
   public List<T> getAll(String tableName);
     public T get(Class<T> x,int id) ;
    
}
