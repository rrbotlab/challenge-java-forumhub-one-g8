package com.arbly.forumhub.controller;

import com.arbly.forumhub.domain.usuario.UsuarioRepository;
import com.arbly.forumhub.domain.usuario.UsuarioDetalheDados;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioRepository repository;

    @GetMapping
    public ResponseEntity<Page<UsuarioDetalheDados>> listar(@PageableDefault(size = 10, sort = {"nome"}) Pageable paginacao){
        var page = repository.findAllByAtivoTrue(paginacao).map(UsuarioDetalheDados::new);
        return ResponseEntity.ok(page);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UsuarioDetalheDados> detalhar(@PathVariable(name = "id") Long id){
        var usuario = repository.getReferenceById(id);
        return ResponseEntity.ok(new UsuarioDetalheDados(usuario));
    }

}
