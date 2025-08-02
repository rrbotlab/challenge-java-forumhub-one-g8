package com.arbly.forumhub.domain.usuario;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class PerfilDTO {

    private Long id;
    private String nome;

    public PerfilDTO() {}

    public PerfilDTO(Long id, String nome) {
        this.id = id;
        this.nome = nome;
    }

}
