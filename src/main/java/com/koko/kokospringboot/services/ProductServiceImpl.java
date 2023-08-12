package com.koko.kokospringboot.services;

import com.koko.kokospringboot.entities.ProductEntity;
import com.koko.kokospringboot.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired

    private ProductRepository productRepository;
    @Override
    public List<ProductEntity> findAll() {
         List<ProductEntity> listaProductos = productRepository.findAll();
         return listaProductos;
    }

    @Override
    public Optional<ProductEntity> findById(Integer id) {
        Optional<ProductEntity> productoSeleccionado = productRepository.findById(id);
        return productoSeleccionado;
    }

    @Override
    public ProductEntity save(ProductEntity productEntity) {
        ProductEntity nuevoProducto = productRepository.save(productEntity);
        return nuevoProducto;
    }

    @Override
    public ProductEntity edit(Integer id, ProductEntity productoEditar){
        Boolean existe = productRepository.existsById(id);

        if (existe) {
            ProductEntity productoSeleccionado = productRepository.findById(id).get();
            productoSeleccionado.setCategoriaProducto(productoEditar.getCategoriaProducto());
            productoSeleccionado.setNombreProducto(productoEditar.getNombreProducto());
            productoSeleccionado.setDescripcionProducto(productoEditar.getDescripcionProducto());
            productoSeleccionado.setPrecioProducto(productoEditar.getPrecioProducto());
            productoSeleccionado.setImgProducto(productoEditar.getImgProducto());
            productoSeleccionado.setCategoriaProduct(productoEditar.getCategoriaProduct());
            productoSeleccionado.setFichaProducto(productoEditar.getFichaProducto());

            return productRepository.save(productoSeleccionado);
        }
        return null;
    }

    @Override
    public void delete(Integer id) {
        productRepository.deleteById(id);
    }
}

