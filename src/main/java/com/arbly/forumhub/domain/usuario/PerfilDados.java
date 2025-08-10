package com.arbly.forumhub.domain.usuario;

import jakarta.validation.constraints.NotBlank;

public record PerfilDados(

        Long id,
        @NotBlank
        String nome

){


}
