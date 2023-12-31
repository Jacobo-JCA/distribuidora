package com.example.distribuidora.service.impl;

import com.example.distribuidora.exception.ModelNotFoundException;
import com.example.distribuidora.repository.IGenericRepo;
import com.example.distribuidora.service.ICRUD;

import java.util.List;

public abstract class CRUDImpl<T, ID> implements ICRUD<T, ID> {

    protected abstract IGenericRepo<T, ID> getRepo();
    @Override
    public T save(T t) throws Exception {
        return getRepo().save(t);
    }

    @Override
    public List<T> readAll() throws Exception {
        return getRepo().findAll();
    }

    @Override
    public T readById(ID id) throws Exception {
        getRepo().findById(id).orElseThrow(() -> new ModelNotFoundException("ID NOT EXIST " + id));
        return getRepo().findById(id).orElse(null);
    }

    @Override
    public T update(T t, ID id) throws Exception {
        getRepo().findById(id).orElseThrow(() -> new ModelNotFoundException("ID NOT EXIST " + id));
        return getRepo().save(t);
    }

    @Override
    public void delete(ID id) throws Exception {
        getRepo().findById(id).orElseThrow(() -> new ModelNotFoundException("ID NOT EXIST " + id));
        getRepo().deleteById(id);
    }
}
