package com.arbly.forumhub.domain.topico;

import com.arbly.forumhub.domain.curso.CursoDetalheDados;
import com.arbly.forumhub.domain.resposta.RespostaDetalheDados;
import com.arbly.forumhub.domain.usuario.UsuarioListagemDados;

import java.time.LocalDateTime;
import java.util.List;

public record TopicoDetalheDados(

        Long id,
        String titulo,
        String mensagem,
        LocalDateTime dataCriacao,
        String status,
        UsuarioListagemDados autor,
        CursoDetalheDados curso,
        List<RespostaDetalheDados> respostas,
        Boolean ativo

) {


    public TopicoDetalheDados(Topico topico) {
        this(topico.getId(),
                topico.getTitulo(),
                topico.getMensagem(),
                topico.getDataCriacao(),
                topico.getStatus(),
                new UsuarioListagemDados(topico.getAutor()),
                new CursoDetalheDados(topico.getCurso()),
                topico.getRespostas().stream()
                        .map(r -> new RespostaDetalheDados(r)).toList(),
                topico.getAtivo()
        );
    }


}
