package com.koko.kokospringboot.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity //Con esto indicamos que es una entidad para ser representada en la base de datos//
@Table(name= "recetas") //Acá indicamos el nombre que tendra la tabla
@NoArgsConstructor//Constructor Vacío
@AllArgsConstructor//Constructor LLeno
@Getter//Getters
@Setter//Setters
public class RecipeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    //Definimos datos de la tabla

    private Integer recetaId;
    private String nombreReceta;
    @Column(columnDefinition = "LONGTEXT")
    private String desarrolloReceta;
    private String imgReceta;
    @Column(columnDefinition = "LONGTEXT")
    private String ingredientesReceta;

    //@Column (Aqui va una FK: name= "categoriaId")

    /*@JsonIgnore//Elimina el problema de la recursividad
    @ManyToMany
    @JoinTable(
            name = "categoria_recetas",
            joinColumns = @JoinColumn(name = "id_receta"),
            inverseJoinColumns = @JoinColumn(name = "categoria_id")
    )
    private List<CategoryEntity> categoriaRecetas; */
}
