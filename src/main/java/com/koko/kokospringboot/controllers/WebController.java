package com.koko.kokospringboot.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class WebController {
    //Permite mostrar la vista del login al acceder a la ruta
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String mostrarLogin(){
        return "login"; //retorna la vista del login.html
    }

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String mostrarHello(){
        return "hello";
    }
}
