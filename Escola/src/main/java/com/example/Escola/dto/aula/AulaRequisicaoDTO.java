package com.example.Escola.dto.aula;

import java.time.LocalDateTime;

public record AulaRequisicaoDTO(
        Long turmaId,
        LocalDateTime dataHora,
        String assunto
) {
}
