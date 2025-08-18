package com.arbly.forumhub.controller;

import com.arbly.forumhub.domain.curso.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/cursos")
public class CursoController {

    @Autowired
    CursoRepository repository;

    @GetMapping
    public ResponseEntity<Page<CursoListagemDados>> listar(Pageable paginacao){
        var page = repository.findAllByAtivoTrue(paginacao).map(CursoListagemDados::new);
        return ResponseEntity.ok(page);
    }

}
