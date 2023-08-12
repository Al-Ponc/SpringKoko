package com.koko.kokospringboot.controllers;

import com.koko.kokospringboot.entities.NoticeEntity;
import com.koko.kokospringboot.services.NoticeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping("/api")
public class NoticeController {
    @Autowired
    private NoticeServiceImpl noticeService;
    @GetMapping("aviso/{id}")
    private ResponseEntity<NoticeEntity> buscarPorId(@PathVariable("id") Integer id) {
        Optional<NoticeEntity> avisoSeleccionado = noticeService.findById(id);
        return ResponseEntity.ok(avisoSeleccionado.get());
    }
    @PutMapping("editar_aviso/{id}")
    public ResponseEntity<NoticeEntity> editarAviso(@PathVariable Integer id , @RequestBody
    NoticeEntity noticeEditar) {
        return ResponseEntity.ok(noticeService.editarAviso(id, noticeEditar));
    }
}