package com.koko.kokospringboot.repositories;

import com.koko.kokospringboot.entities.RolEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RolRepository extends JpaRepository<RolEntity, Integer> {

    RolEntity findRolEntityByTipoRol(String tipoRol);
}
