package com.example.Escola.dto.turma;

import java.util.List;

public record TurmaRequisicaoDTO(
        String nome,
        Long cursoId,
        Long professorId
) {
}
