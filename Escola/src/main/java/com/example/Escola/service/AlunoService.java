package com.example.Escola.service;

import com.example.Escola.model.Aluno;
import com.example.Escola.repository.AlunoRepository;

import java.sql.SQLException;
import java.util.List;

public class AlunoService {
    AlunoRepository alunoRepository = new AlunoRepository();

    public Aluno cadastrarNovoAluno(Aluno aluno) throws SQLException {
        if(aluno.getNome().isEmpty()){
            throw new RuntimeException("Aluno não cadastrado");
        }
        return alunoRepository.criarAluno(aluno);
    }

    public List<Aluno> buscarTodos() throws SQLException {
           List<Aluno> alunos = alunoRepository.buscarTodos();
        return List.of();
    }


}
