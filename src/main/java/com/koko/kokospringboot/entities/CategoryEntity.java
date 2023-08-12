package com.koko.kokospringboot.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table (name = "categoria")
@NoArgsConstructor//Constructor Vacío
@AllArgsConstructor//Constructor LLeno
@Getter//Getters
@Setter//Setters
public class CategoryEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer categoriaId;
    private String nombreCategoria;
    private Byte imgCategoria;

    @JsonManagedReference
    @OneToMany(mappedBy = "categoriaProducto", cascade = CascadeType.ALL)
    private List<ProductEntity> productosCategoria;
}