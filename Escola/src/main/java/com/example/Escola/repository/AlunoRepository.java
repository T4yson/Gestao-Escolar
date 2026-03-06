package com.example.Escola.repository;

import com.example.Escola.model.Aluno;
import com.example.Escola.utils.Conexão;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class AlunoRepository {


    public Aluno criarAluno(Aluno aluno) throws SQLException {
        String query = "INSET INTO aluno (nome, email, matricula, data_nascimento) VALUES (?, ?, ?, ?, ?)";

        try (Connection conn = Conexão.conectar();
             PreparedStatement stmt = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {

            stmt.setString(1, aluno.getNome());
            stmt.setString(2, aluno.getEmail());
            stmt.setString(3, aluno.getMatricula());
            stmt.setDate(4, aluno.getDataNascimento());

            ResultSet rs = stmt.getGeneratedKeys();
            if (rs.next()) {

                aluno.setId(rs.getLong(1));
            }
        }
        return aluno;
    }

    public Aluno buscarPorId(Long id) throws SQLException {
        String query = "SELECT id, nome, email, matricula, dta_nascimento FROM aluno WHERE id = ?";

        try (Connection conn = Conexão.conectar();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setLong(1, id);

            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new Aluno(

                        rs.getLong("id"),
                        rs.getString("nome"),
                        rs.getString("email"),
                        rs.getString("matricula"),
                        rs.getDate("data_nascimento")
                );
            }
        }
        return null;
    }

    public List<Aluno> buscarTodos() throws SQLException {
        String query = "SELECT id, nome, email, matricula, data_nascimento FROM aluno";

        ArrayList<Aluno> lista = new ArrayList<>();

        try (Connection conn = Conexão.conectar();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                lista.add(new Aluno(

                        rs.getLong("id"),
                        rs.getString("nome"),
                        rs.getString("email"),
                        rs.getString("matricula"),
                        rs.getDate("data_nascimento")

                ));
            }
        }
        return lista;
    }

    public void atualizar(Aluno aluno) throws SQLException {
        String query = "UPDATE aluno SET nome = ?, email = ? matricula = ?, data_nascimento = ? WHERE id = ?";

        try (Connection conn = Conexão.conectar();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, aluno.getNome());
            stmt.setString(2, aluno.getEmail());
            stmt.setString(3, aluno.getMatricula());
            stmt.setDate(4, aluno.getDataNascimento());
            stmt.setLong(5, aluno.getId());
            stmt.executeUpdate();
        }
    }

    public void deletar(Long id) throws SQLException {
        String query = "DELETE FROM aluno WHERE id = ?";

        try (Connection conn = Conexão.conectar();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setLong(1, id);
            stmt.executeUpdate();
        }
    }
}