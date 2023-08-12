package com.koko.kokospringboot.services;

import com.koko.kokospringboot.entities.RecipeEntity;
import com.koko.kokospringboot.repositories.RecipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RecipeServiceImpl implements RecipeService {

    @Autowired
    private RecipeRepository recipeRepository;

    @Override
    public List<RecipeEntity> findAll() {
        return recipeRepository.findAll();
    }

    @Override
    public Optional<RecipeEntity> findById(Integer id) {
        return recipeRepository.findById(id);
    }

    @Override
    public RecipeEntity save(RecipeEntity recipeEntity) {
        return recipeRepository.save(recipeEntity);
    }

    @Override
    public RecipeEntity editarReceta(Integer recetaId, RecipeEntity recipeEditar) {
        Optional<RecipeEntity> recetaSeleccionada = recipeRepository.findById(recetaId);
        if (recetaSeleccionada.isPresent()) {
            RecipeEntity receta = recetaSeleccionada.get();
            receta.setNombreReceta(recipeEditar.getNombreReceta());
            receta.setDesarrolloReceta(recipeEditar.getDesarrolloReceta());
            receta.setImgReceta(recipeEditar.getImgReceta());
            return recipeRepository.save(receta);
        }
        return null;
    }

    @Override
    public void delete(Integer id) {
        if (recipeRepository.existsById(id)) {
            recipeRepository.deleteById(id);
        } else {
            throw new IllegalArgumentException("No se encontró ninguna receta con el ID proporcionado: " + id);
        }
    }
}
