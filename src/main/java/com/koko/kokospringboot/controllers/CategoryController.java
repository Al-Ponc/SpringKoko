package com.koko.kokospringboot.controllers;


import com.koko.kokospringboot.entities.CategoryEntity;
import com.koko.kokospringboot.services.CategoryServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin("*")//Nos permite indica que se aceptan peticiones desde cualquier lado
@RequestMapping("/categorias")//Esta anotación nos permite indicar el enrutamiento base
public class CategoryController {

    @Autowired
    private CategoryServiceImpl categoryService;

    @GetMapping("lista_Categorias")
    public List<CategoryEntity> listaCategoria() {
        return categoryService.findAll();
    }
    @GetMapping("categoria/{id}")
    private ResponseEntity<CategoryEntity> buscarPorId(@PathVariable("id") Integer id) {
        Optional<CategoryEntity> categoriaSeleccionada = categoryService.findById(id);
        return ResponseEntity.ok(categoriaSeleccionada.get());
    }
}
