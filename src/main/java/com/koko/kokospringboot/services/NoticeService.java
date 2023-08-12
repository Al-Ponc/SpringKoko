package com.koko.kokospringboot.services;

import com.koko.kokospringboot.entities.NoticeEntity;

import java.util.Optional;

public interface NoticeService {

    Optional<NoticeEntity> findById(Integer id);
    NoticeEntity editarAviso(Integer avisoId, NoticeEntity noticeEditar);

    }



