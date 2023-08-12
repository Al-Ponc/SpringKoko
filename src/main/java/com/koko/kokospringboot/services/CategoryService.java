package com.koko.kokospringboot.services;

import com.koko.kokospringboot.entities.CategoryEntity;

import java.util.List;
import java.util.Optional;

public interface CategoryService {
    List<CategoryEntity> findAll();
    Optional<CategoryEntity> findById(Integer id);
    /*CategoryEntity save(CategoryEntity categoryEntity); */
    /*void delete(Integer id); */
}
