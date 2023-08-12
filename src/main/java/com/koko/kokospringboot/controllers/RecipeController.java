package com.koko.kokospringboot.controllers;
import com.koko.kokospringboot.entities.RecipeEntity;
import com.koko.kokospringboot.services.RecipeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;
import java.util.Collections;


@RestController
@CrossOrigin("*")
@RequestMapping("/recetario")
public class RecipeController {
    @Autowired
    private RecipeServiceImpl recipeService;

    @GetMapping("receta/{id}")
    private ResponseEntity<RecipeEntity> buscarPorId(@PathVariable("id") Integer id) {
        Optional<RecipeEntity> productoSeleccionado = recipeService.findById(id);
        return ResponseEntity.ok(productoSeleccionado.get());
    }

    @GetMapping("lista_recetas")
    public List<RecipeEntity> enlistar() {
        List<RecipeEntity> allRecipes = recipeService.findAll();
        Collections.reverse(allRecipes); 
        return allRecipes;
    }

    @PostMapping("nueva_receta")
    public ResponseEntity<RecipeEntity> nuevo(@RequestBody RecipeEntity recipeEntity) {
        return ResponseEntity.ok(recipeService.save(recipeEntity));
    }

    @PutMapping("editar_receta/{id}")
    public ResponseEntity<RecipeEntity> editarReceta(@PathVariable Integer id, @RequestBody RecipeEntity recipeEditar) {
        return ResponseEntity.ok(recipeService.editarReceta(id, recipeEditar));
    }

    @DeleteMapping("borrar_receta/{id}")
    public void eliminarReceta(@PathVariable("id") Integer id) {
        recipeService.delete(id);
    }
}
