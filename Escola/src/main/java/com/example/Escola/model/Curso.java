package com.example.Escola.model;

import java.util.List;

public class Curso {

    private int id;
    private String nome;
    private String codigo;
    private List<Integer> listaProfessrorId;

    public Curso(String nome, String codigo, List<Integer> listaProfessrorId) {
        this.nome = nome;
        this.codigo = codigo;
        this.listaProfessrorId = listaProfessrorId;
    }

    public Curso(int id, String nome, String codigo, List<Integer> listaProfessrorId) {
        this.id = id;
        this.nome = nome;
        this.codigo = codigo;
        this.listaProfessrorId = listaProfessrorId;
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

    public List<Integer> getListaProfessrorId() {
        return listaProfessrorId;
    }

    public void setListaProfessrorId(List<Integer> listaProfessrorId) {
        this.listaProfessrorId = listaProfessrorId;
    }
}