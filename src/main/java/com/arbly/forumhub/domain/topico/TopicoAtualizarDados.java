package com.arbly.forumhub.domain.topico;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public record TopicoAtualizarDados(
        @NotNull @Positive
        Long id,
        String titulo,
        String mensagem
) {
}
