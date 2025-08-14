package com.arbly.forumhub.controller;

import com.arbly.forumhub.domain.resposta.*;
import com.arbly.forumhub.domain.usuario.UsuarioAutorize;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("respostas")
public class RespostaController {

    @Autowired
    private RespostaRepository repository;

    @Autowired
    private RespostaService respostaService;

    @PostMapping
    @SecurityRequirement(name = "bearer-key")
    public ResponseEntity<RespostaDetalheDados> criar(@RequestBody @Valid RespostaCriarDados dados, UriComponentsBuilder uriBuilder){
        var resposta = respostaService.criar(dados);
        var uri = uriBuilder.path("/respostas/topico/{id}").buildAndExpand(resposta.getTopico().getId()).toUri();
        return ResponseEntity.created(uri).body(new RespostaDetalheDados(resposta));
    }

    @GetMapping("/topico/{topicoId}")
    public ResponseEntity<Page<RespostaDetalheDados>> listar(@PathVariable long topicoId, Pageable paginacao){
        var page = repository.findAllByTopicoIdAndAtivoTrue(topicoId, paginacao).map(RespostaDetalheDados::new);
        return ResponseEntity.ok(page);
    }

    @PutMapping
    @Transactional
    @SecurityRequirement(name = "bearer-key")
    public ResponseEntity<RespostaDetalheDados> atualizar(@RequestBody @Valid RespostaAtualizarDados dados){
        var resposta = repository.getReferenceById(dados.id());

        if (UsuarioAutorize.autorizeTransacao(resposta.getAutor().getId())) {
            resposta.atualizarInformacoes(dados);
        }

        return ResponseEntity.ok(new RespostaDetalheDados(resposta));
    }

    @DeleteMapping("/{id}")
    @Transactional
    @SecurityRequirement(name = "bearer-key")
    public ResponseEntity<Void> excluir(@PathVariable(name = "id") Long id){
        var resposta = repository.getReferenceById(id);

        if (UsuarioAutorize.autorizeTransacao(resposta.getAutor().getId())) {
            resposta.excluir();
        }

        return ResponseEntity.noContent().build();
    }
}
