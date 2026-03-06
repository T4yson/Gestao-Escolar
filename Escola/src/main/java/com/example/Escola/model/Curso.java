package com.example.Escola.model;

public class Curso {

    private int id;
    private String nome;
    private String codigo;
    private int professrorId;

    public Curso(String nome, String codigo, int professrorId) {
        this.nome = nome;
        this.codigo = codigo;
        this.professrorId = professrorId;
    }

    public Curso(int id, String nome, String codigo, int professrorId) {
        this.id = id;
        this.nome = nome;
        this.codigo = codigo;
        this.professrorId = professrorId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public int getProfessrorId() {
        return professrorId;
    }

    public void setProfessrorId(int professrorId) {
        this.professrorId = professrorId;
    }
}
