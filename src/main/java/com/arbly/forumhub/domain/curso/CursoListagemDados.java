package com.arbly.forumhub.domain.curso;

public record CursoListagemDados(
        Long id,
        String nome,
        String categoria
) {
    public CursoListagemDados(Curso curso) {
        this(curso.getId(), curso.getNome(), curso.getCategoria());
    }
}
