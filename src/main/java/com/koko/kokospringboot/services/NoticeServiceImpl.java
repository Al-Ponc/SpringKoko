package com.koko.kokospringboot.services;


import com.koko.kokospringboot.entities.NoticeEntity;
import com.koko.kokospringboot.repositories.NoticeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class NoticeServiceImpl implements NoticeService{
    @Autowired
    private NoticeRepository noticeRepository;
    @Override
    public Optional<NoticeEntity> findById(Integer id) {
        Optional<NoticeEntity> avisoSeleccionado =noticeRepository.findById(id);
        return avisoSeleccionado;
    }
    @Override
    public NoticeEntity editarAviso(Integer avisoId, NoticeEntity noticeEditar) {
        Boolean existe = noticeRepository.existsById(avisoId);
        if (existe) {
            NoticeEntity avisoSeleccionado = noticeRepository.findById(avisoId).get();
            avisoSeleccionado.setTextoAviso(noticeEditar.getTextoAviso());
            return noticeRepository.save(avisoSeleccionado);
        }
        return null;
    }

}
