package com.koko.kokospringboot.controllers;

import com.koko.kokospringboot.dto.RegistroDto;
import com.koko.kokospringboot.services.MyUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("/user")
public class UserController {

    @Autowired
    MyUserDetailsService myUserDetailsService;

    @PostMapping("/register")
    public ResponseEntity<?> crearNuevoUsuario(@RequestBody RegistroDto datosUsuario){
        myUserDetailsService.guardarNuevoUsuario(datosUsuario);
        return new ResponseEntity<>("Registro de nuevo usuario exitoso", HttpStatus.OK);
    }
}
