package com.example.Escola.model;

import java.util.List;

public class Turma {

    private Long id;
    private String nome;
    private Long cursoId;
    private Long professorId;
    private List<Integer> listaAlunos;

    public Turma(String nome, Long cursoId, Long professorId, List<Integer> listaAlunos) {
        this.nome = nome;
        this.cursoId = cursoId;
        this.professorId = professorId;
        this.listaAlunos = listaAlunos;
    }

    public Turma(Long id, String nome, Long cursoId, Long professorId, List<Integer> listaAlunos) {
        this.id = id;
        this.nome = nome;
        this.cursoId = cursoId;
        this.professorId = professorId;
        this.listaAlunos = listaAlunos;
    }

    public Turma(long id, String nome, long cursoId, long professorId) {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Long getCursoId() {
        return cursoId;
    }

    public void setCursoId(Long cursoId) {
        this.cursoId = cursoId;
    }

    public Long getProfessorId() {
        return professorId;
    }

    public void setProfessorId(Long professorId) {
        this.professorId = professorId;
    }

    public List<Integer> getListaAlunos() {
        return listaAlunos;
    }

    public void setListaAlunos(List<Integer> listaAlunos) {
        this.listaAlunos = listaAlunos;
    }
}
