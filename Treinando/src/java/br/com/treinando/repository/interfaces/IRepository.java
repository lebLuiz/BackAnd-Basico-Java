package br.com.treinando.repository.interfaces;

import java.util.List;

public interface IRepository<T>{
    
    T save(T domain);
    T update(T Domain);
    void delete(Long idDomain);
    T findOne(Long idDomain);
    List<T> findAll();
    
    
    
}
