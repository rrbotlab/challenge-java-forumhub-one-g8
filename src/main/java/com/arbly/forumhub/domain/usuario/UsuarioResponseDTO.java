package com.arbly.forumhub.domain.usuario;

import lombok.Getter;
import lombok.Setter;

import java.util.Set;
import java.util.stream.Collectors;

@Setter
@Getter
public class UsuarioResponseDTO {

    private Long id;
    private String nome;
    private String email;
    private boolean ativo;
    private Set<PerfilDTO> perfis;

    public UsuarioResponseDTO() {}

    public UsuarioResponseDTO(Long id, String nome, String email, boolean ativo, Set<PerfilDTO> perfis) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.ativo = ativo;
        this.perfis = perfis;
    }

    public UsuarioResponseDTO(Usuario usuario) {
        this.id = usuario.getId();
        this.nome = usuario.getNome();
        this.email = usuario.getEmail();
        this.ativo = usuario.isAtivo();
        this.perfis = usuario.getPerfis()
                .stream()
                .map(p -> new PerfilDTO(p.getId(), p.getNome()))
                .collect(Collectors.toSet());
    }
}
