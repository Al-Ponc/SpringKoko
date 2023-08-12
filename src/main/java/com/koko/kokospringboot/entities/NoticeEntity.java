package com.koko.kokospringboot.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name= "avisos")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class NoticeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    //Definimos datos de la tabla

    private Integer avisoId;
    private String textoAviso;

}
