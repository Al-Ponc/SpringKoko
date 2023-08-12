package com.koko.kokospringboot.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;



@Entity
@Table(name= "productos")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ProductEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer productoId;
    private String nombreProducto;
    @Column(columnDefinition = "LONGTEXT")
    private String descripcionProducto;
    private Integer precioProducto;
    private String imgProducto;
    private String categoriaProduct;
    // (Aqui va una FK: name= "categoriaId")
    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "categoria_id")
    private CategoryEntity categoriaProducto;
}