package com.koko.kokospringboot.services;

import com.koko.kokospringboot.dto.RegistroDto;
import com.koko.kokospringboot.entities.RolEntity;
import com.koko.kokospringboot.entities.UserEntity;
import com.koko.kokospringboot.repositories.RolRepository;
import com.koko.kokospringboot.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    RolRepository rolRepository;

    @Autowired
    PasswordEncoder passwordEncoder;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity usuarioSeleccionado = userRepository.findUserEntityByUsername(username);

        //Verificamos la autoridad que tiene según sus roles y las guardamos en una variable authorities
        Set<GrantedAuthority> authorities = usuarioSeleccionado
                .getRolesUsuario()
                .stream()
                .map((rolEntity -> new SimpleGrantedAuthority(rolEntity.getTipoRol())))
                .collect(Collectors.toSet());

        //Retornamos el nuevo User para ser auntenticado por spring security
        return new User(username,
                usuarioSeleccionado.getPassword(),
                authorities);
    }

    public UserEntity guardarNuevoUsuario(RegistroDto datosUsuario){
        UserEntity nuevoUsuario = new UserEntity();
        nuevoUsuario.setUsername(datosUsuario.getUsername());
        nuevoUsuario.setPassword(passwordEncoder.encode(datosUsuario.getPassword()));

        RolEntity rol = rolRepository.findRolEntityByTipoRol("ADMIN");
        nuevoUsuario.setRolesUsuario(Collections.singleton(rol));

        return  userRepository.save(nuevoUsuario);
    }
}
