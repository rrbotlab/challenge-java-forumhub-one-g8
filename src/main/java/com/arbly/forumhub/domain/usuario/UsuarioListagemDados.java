package com.arbly.forumhub.domain.usuario;

public record UsuarioListagemDados(

        Long id,
        String nome

) {

    public UsuarioListagemDados(Usuario usuario) {
        this(
                usuario.getId(),
                usuario.getNome()
                );
    }

}
