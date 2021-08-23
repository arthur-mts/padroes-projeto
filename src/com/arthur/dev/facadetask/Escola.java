package com.arthur.dev.facadetask;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class Escola {

    private final List<Turma> turmas = new ArrayList<>();

    private final List<Curso> cursos = new ArrayList<>(){{
        add(new Curso("Curso padrão"));
    }};

    public Curso getCurso(String codCurso) throws CursoNaoEncontradoException {
        return cursos.stream().filter(cursos -> cursos.getCodCurso().equals(codCurso))
                .findFirst()
                .orElseThrow(() -> new CursoNaoEncontradoException(codCurso));
    }

    public Aluno getAluno(String codAluno) throws AlunoNaoEncontradoException {
        return turmas.stream().map(Turma::getAlunos).flatMap(Collection::stream).collect(Collectors.toList()).stream()
                .filter(aluno -> aluno.getMatricula().equals(codAluno)).findFirst().orElseThrow(() -> new AlunoNaoEncontradoException(codAluno));
    }
}
