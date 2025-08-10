package com.arbly.forumhub.domain.resposta;


import com.arbly.forumhub.domain.usuario.UsuarioListagemDados;

import java.time.LocalDateTime;

public record RespostaDetalheDados(

        Long id,
        String resposta,
        LocalDateTime dataCriacao,
        UsuarioListagemDados autor,
        Boolean solucao

) {

    public RespostaDetalheDados(Resposta dados){

        this(dados.getId(),
                dados.getMensagem(),
                dados.getDataCriacao(),
                new UsuarioListagemDados(dados.getAutor()),
                false);
    }


}
