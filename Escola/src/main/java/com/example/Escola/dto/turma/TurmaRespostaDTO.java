package com.example.Escola.dto.turma;

import com.example.Escola.dto.curso.CursoRespostaDTO;
import com.example.Escola.dto.professor.ProfessorRespostaDTO;
import java.util.List;

public record TurmaRespostaDTO(
        Long id,
        String nome,
        CursoRespostaDTO curso,
        ProfessorRespostaDTO professor
) {
}
