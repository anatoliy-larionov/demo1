package com.epam.mvc.smoke.repository;

import java.io.Serializable;
import java.util.List;

public interface BasicRepository <T extends Serializable> {
    List<T> findAll();
    T update(T o);
    T findById(long id);
    void add(T o);
    void delete(long id);
}
