package com.example.Escola.repository;

import com.example.Escola.model.Aula;
import com.example.Escola.utils.Conexão;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class AulaRepository {

        public Aula criarAula(Aula aula) throws SQLException {
            String query = "INSET INTO aula (turma_id, data_hora, assunto) VALUES (?, ?, ?)";

            try (Connection conn = Conexão.conectar();
                 PreparedStatement stmt = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {

                stmt.setLong(1, aula.getIdTurma());
                stmt.setTimestamp(2, Timestamp.valueOf(aula.getDataHora()));
                stmt.setString(3, aula.getAssunto());

                ResultSet rs = stmt.getGeneratedKeys();
                if (rs.next()) {

                    aula.setId(rs.getLong(1));
                }
            }
            return aula;
        }

        public Aula buscarPorId(Long id) throws SQLException {
            String query = "SELECT id, turma_id, data_hora, assunto FROM aula WHERE id = ?";

            try (Connection conn = Conexão.conectar();
                 PreparedStatement stmt = conn.prepareStatement(query)) {

                stmt.setLong(1, id);

                ResultSet rs = stmt.executeQuery();
                if (rs.next()) {
                    return new Aula(

                            rs.getLong("id"),
                            rs.getLong("idTurma"),
                            rs.getTimestamp("dataHora").toLocalDateTime(),
                            rs.getString("assunto")
                    );
                }
            }
            return null;
        }

        public List<Aula> buscarTodos() throws SQLException {
            String query = "SELECT id, turma_id, data_hora, assunto FROM aula";

            ArrayList<Aula> lista = new ArrayList<>();

            try (Connection conn = Conexão.conectar();
                 PreparedStatement stmt = conn.prepareStatement(query)) {

                ResultSet rs = stmt.executeQuery();
                while (rs.next()) {
                    lista.add(new Aula(

                            rs.getLong("id"),
                            rs.getLong("idTurma"),
                            rs.getTimestamp("dataHora").toLocalDateTime(),
                            rs.getString("assunto")

                    ));
                }
            }
            return lista;
        }

        public void atualizar(Aula aula) throws SQLException {
            String query = "UPDATE aula SET turma_id = ?, data_hora = ? assunto = ?, WHERE id = ?";

            try (Connection conn = Conexão.conectar();
                 PreparedStatement stmt = conn.prepareStatement(query)) {

                stmt.setLong(1, aula.getIdTurma());
                stmt.setTimestamp(2, Timestamp.valueOf(aula.getDataHora()));
                stmt.setString(3, aula.getAssunto());
                stmt.setLong(5, aula.getId());
                stmt.executeUpdate();
            }
        }

        public void deletar(Long id) throws SQLException {
            String query = "DELETE FROM aula WHERE id = ?";

            try (Connection conn = Conexão.conectar();
                 PreparedStatement stmt = conn.prepareStatement(query)) {

                stmt.setLong(1, id);
                stmt.executeUpdate();
            }
        }
    }

