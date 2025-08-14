package com.arbly.forumhub.controller;

import com.arbly.forumhub.domain.topico.*;
import com.arbly.forumhub.domain.usuario.UsuarioAutorize;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/topicos")
public class TopicoController {

    @Autowired
    private TopicoRepository repository;

    @Autowired
    private TopicoService topicoService;

    @PostMapping
    @SecurityRequirement(name = "bearer-key")
    public ResponseEntity<TopicoDetalheDados> criar(@RequestBody @Valid TopicoCriarDados dados, UriComponentsBuilder uriBuilder){
        var topico = topicoService.criar(dados);
        var uri = uriBuilder.path("/topicos/{id}").buildAndExpand(topico.getId()).toUri();
        return ResponseEntity.created(uri).body(new TopicoDetalheDados(topico));
    }

    @GetMapping
    public ResponseEntity<Page<TopicoListagemDados>> listar(Pageable paginacao){
        var page = repository.findAllByAtivoTrue(paginacao).map(TopicoListagemDados::new);
        return ResponseEntity.ok(page);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TopicoDetalheDados> detalharTopico(@PathVariable Long id) {
        var topico = repository.findByIdAndAtivoTrue(id);
        if (topico == null){
            throw new EntityNotFoundException();
        }else {
            return ResponseEntity.ok(new TopicoDetalheDados(topico));
        }
    }

    @PutMapping
    @Transactional
    @SecurityRequirement(name = "bearer-key")
    public ResponseEntity<TopicoDetalheDados> atualizar(@RequestBody @Valid TopicoAtualizarDados dados){
        var topico = repository.getReferenceById(dados.id());

        if (UsuarioAutorize.autorizeTransacao(topico.getAutor().getId())) {
            topico.atualizarInformacoes(dados);
        }

        return ResponseEntity.ok(new TopicoDetalheDados(topico));
    }

    @DeleteMapping("/{id}")
    @Transactional
    @SecurityRequirement(name = "bearer-key")
    public ResponseEntity<Void> excluir(@PathVariable(name = "id") Long id){
        var topico = repository.getReferenceById(id);

        if (UsuarioAutorize.autorizeTransacao(topico.getAutor().getId())) {
            topico.excluir();
        }

        return ResponseEntity.noContent().build();
    }

}
