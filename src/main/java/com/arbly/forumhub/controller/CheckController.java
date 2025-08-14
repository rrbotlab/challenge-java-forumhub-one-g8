package com.arbly.forumhub.controller;

import com.arbly.forumhub.domain.usuario.UsuarioDetails;
import com.arbly.forumhub.domain.usuario.UsuarioDetalheDados;
import com.arbly.forumhub.domain.usuario.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("check")
public class CheckController {

    @Autowired
    UsuarioRepository usuarioRepository;

    @GetMapping
    public ResponseEntity<?> check(){
        Map<String, String> map = new HashMap<>();
        map.put("msg","checked v3");
        return ResponseEntity.ok(map);
    }

    @GetMapping("/who")
    public ResponseEntity<?> who(){
        Map<String, Object> map = new HashMap<>();
        var usuarioAutenticado = (UsuarioDetails)SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        map.put("Username", usuarioAutenticado.getUsername());
        map.put("Authorities", usuarioAutenticado.getAuthorities());
        map.put("Password", usuarioAutenticado.getPassword());
        map.put("Usuario", new UsuarioDetalheDados(usuarioAutenticado.getUsuario()));

        return ResponseEntity.ok(map);
    }
}
