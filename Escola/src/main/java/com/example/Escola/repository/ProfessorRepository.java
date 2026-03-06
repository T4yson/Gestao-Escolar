package com.example.Escola.repository;


import com.example.Escola.model.Professor;
import com.example.Escola.utils.Conexão;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class ProfessorRepository {

    public Professor criarProfessor(Professor professor) throws SQLException {
        String query = "INSET INTO professor (nome, email, disciplina) VALUES (?, ?, ?) ";

        try (Connection conn = Conexão.conectar();
             PreparedStatement stmt = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {

            stmt.setLong(1, professor.getId());
            stmt.setString(2, professor.getNome());
            stmt.setString(3, professor.getEmail());
            stmt.setString(4, professor.getDisciplina());

            ResultSet rs = stmt.getGeneratedKeys();
            if (rs.next()) {

                professor.setId(rs.getLong(1));
            }
        }
        return professor;
    }

    public Professor buscarPorId(Long id) throws SQLException {
        String query = "SELECT id, nome, email, disciplina FROM professor WHERE id = ?";

        try (Connection conn = Conexão.conectar();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setLong(1, id);

            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new Professor(

                        rs.getLong("id"),
                        rs.getString("nome"),
                        rs.getString("email"),
                        rs.getString("disciplina")
                );
            }
        }
        return null;
    }

    public List<Professor> buscarTodos() throws SQLException {
        String query = "SELECT id, nome, email, disciplina FROM professor";

        ArrayList<Professor> lista = new ArrayList<>();

        try (Connection conn = Conexão.conectar();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                lista.add(new Professor(

                        rs.getLong("id"),
                        rs.getString("nome"),
                        rs.getString("email"),
                        rs.getString("disciplina")

                ));
            }
        }
        return lista;
    }

    public void atualizar(Professor professor) throws SQLException {
        String query = "UPDATE professor SET nome = ?, email = ?, disciplina = ? WHERE id = ?";

        try (Connection conn = Conexão.conectar();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, professor.getNome());
            stmt.setString(2, professor.getEmail());
            stmt.setString(3, professor.getDisciplina());
            stmt.executeUpdate();
        }
    }

    public void deletar(Long id) throws SQLException {
        String query = "DELETE FROM professor WHERE id = ?";

        try (Connection conn = Conexão.conectar();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setLong(1, id);
            stmt.executeUpdate();
        }
    }
}

