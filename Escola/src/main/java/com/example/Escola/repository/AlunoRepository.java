package com.example.Escola.repository;

import com.example.Escola.model.Aluno;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;

@Repository
public class AlunoRepository {


    public Aluno criarAluno (Aluno aluno) throws SQLException {
        String query = "INSET INTO aluno (nome, email, matricula, data_nascimento";

        try (){

        }
    }
}
