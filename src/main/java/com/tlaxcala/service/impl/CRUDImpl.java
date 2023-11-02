package com.tlaxcala.service.impl;

import java.util.List;
// import java.util.function.Supplier;

import com.tlaxcala.exception.ModelNotFoundException;
import com.tlaxcala.repo.IGenericRepo;
import com.tlaxcala.service.ICRUD;

public abstract class CRUDImpl<T, ID> implements ICRUD<T, ID> {

    protected abstract IGenericRepo<T, ID> getRepo();

    @Override
    public T save(T t) {
        return getRepo().save(t);
    }

    @Override
    public T update(T t, ID id) {
        return getRepo().save(t);
    }

    @Override
    public List<T> findAll() {
        return getRepo().findAll();
    }

    @Override
    public T findById(ID id) {
        //Supplier
        return getRepo().findById(id).orElseThrow(()-> new ModelNotFoundException("ID NOT FOUND: " + id));
    }

    @Override
    public void delete(ID id) {
        getRepo().deleteById(id);
    }
    
}
