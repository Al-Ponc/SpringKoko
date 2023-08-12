package com.koko.kokospringboot.repositories;

import com.koko.kokospringboot.entities.RecipeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository //El extends llama la herencia de la clase
public interface RecipeRepository extends JpaRepository<RecipeEntity, Integer> {

}
