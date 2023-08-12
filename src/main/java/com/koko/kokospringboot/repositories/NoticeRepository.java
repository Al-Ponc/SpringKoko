package com.koko.kokospringboot.repositories;

import com.koko.kokospringboot.entities.NoticeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository //El extends llama la herencia de la clase
public interface NoticeRepository extends JpaRepository<NoticeEntity, Integer> {

}