package com.koko.kokospringboot.services;

import com.koko.kokospringboot.entities.ProductEntity;

import java.util.List;
import java.util.Optional;

public interface ProductService {
    List<ProductEntity> findAll();
    Optional<ProductEntity> findById(Integer id);

    ProductEntity save(ProductEntity productEntity);

    ProductEntity edit(Integer id, ProductEntity productoEditar);

    void delete(Integer id);

}
