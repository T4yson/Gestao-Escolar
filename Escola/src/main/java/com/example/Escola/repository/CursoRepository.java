package com.example.Escola.repository;

import com.example.Escola.model.Curso;
import com.example.Escola.utils.Conexão;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class CursoRepository {

    public Curso criarCurso(Curso curso) throws SQLException {
        String query = "INSET INTO curso (nome, codigo) VALUES (?, ?) ";

        try (Connection conn = Conexão.conectar();
             PreparedStatement stmt = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {

            stmt.setLong(1, curso.getId());
            stmt.setString(2, curso.getNome());
            stmt.setString(3, curso.getCodigo());

            ResultSet rs = stmt.getGeneratedKeys();
            if (rs.next()) {

                curso.setId(rs.getLong(1));
            }
        }
        return curso;
    }

    public Curso buscarPorId(Long id) throws SQLException {
        String query = "SELECT id, nome, codigo FROM curso WHERE id = ?";

        try (Connection conn = Conexão.conectar();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setLong(1, id);

            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new Curso(

                        rs.getLong("id"),
                        rs.getString("nome"),
                        rs.getString("codigo")
                );
            }
        }
        return null;
    }

    public List<Curso> buscarTodos() throws SQLException {
        String query = "SELECT id, nome, codigo FROM curso";

        ArrayList<Curso> lista = new ArrayList<>();

        try (Connection conn = Conexão.conectar();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                lista.add(new Curso(

                        rs.getLong("id"),
                        rs.getString("nome"),
                        rs.getString("codigo")

                ));
            }
        }
        return lista;
    }

    public void atualizar(Curso curso) throws SQLException {
        String query = "UPDATE curso SET nome = ?, codigo = ? WHERE id = ?";

        try (Connection conn = Conexão.conectar();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(3, curso.getNome());
            stmt.setString(3, curso.getCodigo());
            stmt.setLong(5, curso.getId());
            stmt.executeUpdate();
        }
    }

    public void deletar(Long id) throws SQLException {
        String query = "DELETE FROM curso WHERE id = ?";

        try (Connection conn = Conexão.conectar();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setLong(1, id);
            stmt.executeUpdate();
        }
    }
}

