package com.arbly.forumhub.domain.topico;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public record TopicoCriarDados(
        @NotBlank
        String titulo,
        @NotBlank
        String mensagem,
        @NotNull @Positive
        Long cursoId
) {
}
