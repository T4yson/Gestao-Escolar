package com.example.Escola.dto.aluno;

import java.time.LocalDate;

public record AlunoRespostaDTO(
        Long id,
        String nome,
        String email,
        String matricula,
        LocalDate dataNascimento
) {
}
