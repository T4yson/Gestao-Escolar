package com.example.Escola.dto.aula;

import java.time.LocalDateTime;

public record AulaRespostaDTO(
        Long id,
        String nomeTurma,
        LocalDateTime dataHora,
        String assunto
) {
}
