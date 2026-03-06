package com.example.Escola.model;

import java.time.LocalDateTime;

public class Aula {

    private Long id;
    private Long idTurma;
    private LocalDateTime dataHora;
    private String assunto;

    public Aula(Long idTurma, LocalDateTime dataHora, String assunto) {
        this.idTurma = idTurma;
        this.dataHora = dataHora;
        this.assunto = assunto;
    }

    public Aula(Long id, Long idTurma, LocalDateTime dataHora, String assunto) {
        this.id = id;
        this.idTurma = idTurma;
        this.dataHora = dataHora;
        this.assunto = assunto;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getIdTurma() {
        return idTurma;
    }

    public void setIdTurma(Long idTurma) {
        this.idTurma = idTurma;
    }

    public LocalDateTime getDataHora() {
        return dataHora;
    }

    public void setDataHora(LocalDateTime dataHora) {
        this.dataHora = dataHora;
    }

    public String getAssunto() {
        return assunto;
    }

    public void setAssunto(String assunto) {
        this.assunto = assunto;
    }
}
