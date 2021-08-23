package com.arthur.dev.facadetask;

import java.util.ArrayList;
import java.util.List;

public class Turma {

    private List<Aluno> alunos;
    private Curso curso;


    public void addAluno(Aluno aluno) {
        this.alunos.add(aluno);
    }
    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    public List<Aluno> getAlunos() {
        return alunos;
    }

    public void setAlunos(List<Aluno> alunos) {
        this.alunos = alunos;
    }

    public Turma(Curso curso) {
        this.alunos = new ArrayList<>();
        this.curso = curso;
    }

    public Turma() {
        new Turma(null);
    }
}
