package com.koko.kokospringboot.services;

import com.koko.kokospringboot.entities.CategoryEntity;
import com.koko.kokospringboot.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryServiceImpl implements CategoryService{
    @Autowired //Inyeccion de dependencia de repositorio (conectar con "repositories")

    private CategoryRepository categoryRepository;
    @Override
    public List<CategoryEntity> findAll() {
        List<CategoryEntity> listaCategorias = categoryRepository.findAll();
        return listaCategorias;
    }


    @Override
    public Optional<CategoryEntity> findById(Integer id) {
        Optional<CategoryEntity> categoriaSeleccionada = categoryRepository.findById(id);
        return categoriaSeleccionada;
    }


}
