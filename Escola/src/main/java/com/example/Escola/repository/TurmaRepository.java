package com.example.Escola.repository;

import com.example.Escola.model.Turma;
import com.example.Escola.utils.Conexão;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class TurmaRepository {

    public Turma criarTurma(Turma turma) throws SQLException {
        String query = "INSET INTO professor (nome, curso_id, professor_id) VALUES (?, ?, ?, ?) ";

        try (Connection conn = Conexão.conectar();
             PreparedStatement stmt = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {

            stmt.setLong(1, turma.getId());
            stmt.setString(2, turma.getNome());
            stmt.setLong(3, turma.getCursoId());
            stmt.setLong(4, turma.getProfessorId());

            ResultSet rs = stmt.getGeneratedKeys();
            if (rs.next()) {

                turma.setId(rs.getLong(1));
            }
        }
        return turma;
    }

    public Turma buscarPorId(Long id) throws SQLException {
        String query = "SELECT id, nome, curso_id, professor_id FROM turma WHERE id = ?";

        try (Connection conn = Conexão.conectar();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setLong(1, id);

            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new Turma(

                        rs.getLong("id"),
                        rs.getString("nome"),
                        rs.getLong("curso_id"),
                        rs.getLong("professor_id")
                );
            }
        }
        return null;
    }

    public List<Turma> buscarTodos() throws SQLException {
        String query = "SELECT id, nome, curso_id, professor_id FROM turma";

        ArrayList<Turma> lista = new ArrayList<>();

        try (Connection conn = Conexão.conectar();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                lista.add(new Turma(

                        rs.getLong("id"),
                        rs.getString("nome"),
                        rs.getLong("curso_id"),
                        rs.getLong("professor_id")

                ));
            }
        }
        return lista;
    }

    public void atualizar(Turma turma) throws SQLException {
        String query = "UPDATE turma SET nome = ?, curso_id = ?, professor_id = ? WHERE id = ?";

        try (Connection conn = Conexão.conectar();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, turma.getNome());
            stmt.setLong(2, turma.getCursoId());
            stmt.setLong(3, turma.getProfessorId());
            stmt.executeUpdate();
        }
    }

    public void deletar(Long id) throws SQLException {
        String query = "DELETE FROM turma WHERE id = ?";

        try (Connection conn = Conexão.conectar();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setLong(1, id);
            stmt.executeUpdate();
        }
    }
}

