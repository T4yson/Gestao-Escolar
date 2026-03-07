package com.example.Escola.mapper;

import com.example.Escola.dto.aluno.AlunoRequisicaoDTO;
import com.example.Escola.dto.aluno.AlunoRespostaDTO;
import com.example.Escola.model.Aluno;
import org.springframework.stereotype.Component;

@Component
public class AlunoMapper {
    public Aluno paraEntidade (

            AlunoRequisicaoDTO alunoRequisicaoDTO
    ) {
        return new Aluno(
                alunoRequisicaoDTO.nome(),
                alunoRequisicaoDTO.email(),
                alunoRequisicaoDTO.matricula(),
                alunoRequisicaoDTO.dataNascimento()
        );
    }

    public AlunoRespostaDTO paraResposta(

            Aluno aluno
    ){
        return new AlunoRespostaDTO(
                aluno.getId(),
                aluno.getNome(),
                aluno.getEmail(),
                aluno.getMatricula(),
                aluno.getDataNascimento().toLocalDate()
        );
    }
}
