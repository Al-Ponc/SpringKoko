package com.koko.kokospringboot.controllers;

import com.koko.kokospringboot.entities.ProductEntity;
import com.koko.kokospringboot.services.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections; 
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping("/productos")
public class ProductController {

    @Autowired
    private ProductServiceImpl productService;

    @GetMapping("lista_Productos")
    public List<ProductEntity> listaProductos() {
        List<ProductEntity> allProducts = productService.findAll();
        Collections.reverse(allProducts); 
        return allProducts;
    }

    @GetMapping("producto/{id}")
    private ResponseEntity<ProductEntity> buscarPorId(@PathVariable("id") Integer id) {
        Optional<ProductEntity> productoSeleccionado = productService.findById(id);
        return ResponseEntity.ok(productoSeleccionado.get());
    }

    @PostMapping("nuevoProducto")
    public ResponseEntity<ProductEntity> nuevo(@RequestBody ProductEntity productEntity) {
        return ResponseEntity.ok(productService.save(productEntity));
    }

    @PutMapping("editarProducto/{id}")
    public ResponseEntity<ProductEntity> editarProductoPorId(@PathVariable Integer id, @RequestBody
                                                             ProductEntity productoEditar){
        return ResponseEntity.ok(productService.edit(id, productoEditar));
    }

    @DeleteMapping("borrar_producto/{id}")
    public void eliminarProducto(@PathVariable("id") Integer id) {
        productService.delete(id);
    }
}
