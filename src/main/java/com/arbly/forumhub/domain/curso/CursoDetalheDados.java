package com.arbly.forumhub.domain.curso;

public record CursoDetalheDados(
        Long id,
        String nome,
        String Categoria
){
    public CursoDetalheDados(Curso curso) {
        this(curso.getId(), curso.getNome(), curso.getCategoria());
    }
}
