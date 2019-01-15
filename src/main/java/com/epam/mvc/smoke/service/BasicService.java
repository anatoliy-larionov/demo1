package com.epam.mvc.smoke.service;

import java.io.Serializable;
import java.util.List;

public interface BasicService<T extends Serializable> {
    List<T> findAll();
    T update(T o);
    T findById(int id);
    void add(T o);
    void delete(int id);
}
