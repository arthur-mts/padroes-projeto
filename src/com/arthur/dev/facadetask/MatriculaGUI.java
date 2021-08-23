package com.arthur.dev.facadetask;

import java.util.Objects;

public class MatriculaGUI {

    private final Escola escola = new Escola();
    public void matricular(String codAluno, String codCurso, Turma turma) throws CursoNaoEncontradoException, AlunoNaoEncontradoException {

        if(Objects.isNull(turma)) {
            turma = new Turma();
            Curso c = escola.getCurso(codCurso);
            turma.setCurso(c);
        }
        Aluno aluno = escola.getAluno(codAluno);
        turma.addAluno(aluno);
    }

    public void exibirStatus(Turma turma) {

    }
}
