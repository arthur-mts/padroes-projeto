package com.arthur.dev.facadetask;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class Escola {

    public static String CURSO_PADRAO = "123";

    private final List<Turma> turmas = new ArrayList<>();

    private final List<Curso> cursos = new ArrayList<>() {{
        add(new Curso("Curso padrão", CURSO_PADRAO));
    }};

    public Curso getCurso(String codCurso) throws CursoNaoEncontradoException {
        return cursos.stream().filter(cursos -> cursos.getCodCurso().equals(codCurso))
                .findFirst()
                .orElseThrow(() -> new CursoNaoEncontradoException(codCurso));
    }

    public Aluno getAluno(String codAluno) throws AlunoNaoEncontradoException {
        return turmas.stream().map(Turma::getAlunos).flatMap(Collection::stream).
                filter(aluno -> aluno.getMatricula().equals(codAluno)).findFirst().orElseThrow(() -> new AlunoNaoEncontradoException(codAluno));
    }

    public void validaMatricula(String codAluno) throws MatriculaJaCadastradaException {
        for (Aluno aluno : turmas.stream().map(Turma::getAlunos).flatMap(Collection::stream).collect(Collectors.toList())) {
            if (aluno.getMatricula().equals(codAluno))
                throw new MatriculaJaCadastradaException(codAluno);
        }
    }

    public Turma criarTurma(String codCurso, String nomeTurma) throws CursoNaoEncontradoException {
        Turma turma = new Turma(this.getCurso(codCurso), nomeTurma);
        turmas.add(turma);
        return turma;
    }

    public Aluno criarAluno(String nome, String codAluno) {
        return new Aluno(nome, codAluno);
    }
}
