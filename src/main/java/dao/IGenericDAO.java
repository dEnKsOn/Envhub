package dao;

import java.util.List;

// T = L'entité (ex: Technologie), ID = Le type de la clé primaire (ex: Integer)
public interface IGenericDAO<T, ID> {
    
    T findById(ID id);
    
    List<T> findAll();
    
    boolean save(T entity);
    
    boolean update(T entity);
    
    boolean delete(ID id);
}