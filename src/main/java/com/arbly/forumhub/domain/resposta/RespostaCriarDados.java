package com.arbly.forumhub.domain.resposta;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public record RespostaCriarDados(
        @NotBlank
        String mensagem,
        @NotNull @Positive
        Long topicoId

) {
}
