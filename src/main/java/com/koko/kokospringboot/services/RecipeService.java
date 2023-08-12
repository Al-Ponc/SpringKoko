package com.koko.kokospringboot.services;

import com.koko.kokospringboot.entities.RecipeEntity;

import java.util.List;
import java.util.Optional;

public interface RecipeService {
    List<RecipeEntity> findAll();
    Optional<RecipeEntity> findById(Integer id);

    RecipeEntity save(RecipeEntity recipeEntity);

    RecipeEntity editarReceta(Integer recetaId, RecipeEntity recipeEditar);

    void delete(Integer id);

}
