package com.example.Escola.repository;

import com.example.Escola.model.Curso;
import com.example.Escola.model.Nota;
import com.example.Escola.utils.Conexão;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class NotaRepository {

    public Nota criarNota(Nota nota) throws SQLException {
        String query = "INSET INTO curso (aluno_id, aula_id, valor) VALUES (?, ?, ?) ";

        try (Connection conn = Conexão.conectar();
             PreparedStatement stmt = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {

            stmt.setLong(1, nota.getId());
            stmt.setLong(2, nota.getAlunoId());
            stmt.setLong(3, nota.getAulaId());
            stmt.setDouble(4, nota.getValor());

            ResultSet rs = stmt.getGeneratedKeys();
            if (rs.next()) {

                nota.setId(rs.getLong(1));
            }
        }
        return nota;
    }

    public Nota buscarPorId(Long id) throws SQLException {
        String query = "SELECT id, aluno_id, aula_id, valor FROM curso WHERE id = ?";

        try (Connection conn = Conexão.conectar();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setLong(1, id);

            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new Nota(

                        rs.getLong("id"),
                        rs.getLong("aluno_id"),
                        rs.getLong("aula_id"),
                        rs.getDouble("valor")
                );
            }
        }
        return null;
    }

    public List<Nota> buscarTodos() throws SQLException {
        String query = "SELECT id, aluno_id, aula_id, valor FROM nota";

        ArrayList<Nota> lista = new ArrayList<>();

        try (Connection conn = Conexão.conectar();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                lista.add(new Nota(

                        rs.getLong("id"),
                        rs.getLong("aluno_id"),
                        rs.getLong("aula_id"),
                        rs.getDouble("valor")

                ));
            }
        }
        return lista;
    }

    public void atualizar(Nota nota) throws SQLException {
        String query = "UPDATE nota SET aluno_id = ?, aula_id = ?, valor = ? WHERE id = ?";

        try (Connection conn = Conexão.conectar();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setLong(1, nota.getAlunoId());
            stmt.setLong(2, nota.getAulaId());
            stmt.setDouble(3, nota.getValor());
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

