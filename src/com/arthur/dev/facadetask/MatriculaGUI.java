package com.arthur.dev.facadetask;

import static com.arthur.dev.facadetask.Escola.CURSO_PADRAO;

import java.util.Objects;

public class MatriculaGUI {

    private final Escola escola = new Escola();

    public void matricular(Aluno aluno, String codCurso, Turma turma) throws CursoNaoEncontradoException, MatriculaJaCadastradaException {
        if(Objects.isNull(turma)) {
            turma = new Turma();
            Curso c = escola.getCurso(codCurso);
            turma.setCurso(c);
        }
        System.out.println("Aluno "+ aluno.getNome() + "["+aluno.getMatricula()+"] matriculado no curso: "+ escola.getCurso(CURSO_PADRAO).getNome());
        escola.validaMatricula(aluno.getMatricula());
        turma.addAluno(aluno);
    }

    public void exibirStatus(Turma turma) {
        System.out.println("***TURMA " + turma.getCurso().getNome()+"***");
        turma.getAlunos().forEach((aluno -> System.out.println("ALUNO: " + aluno.getNome())));
    }

    public static void main(String[] args) throws CursoNaoEncontradoException, MatriculaJaCadastradaException {
        MatriculaGUI interfaceGUI = new MatriculaGUI();
        Turma primeiraTurma = interfaceGUI.escola.criarTurma(CURSO_PADRAO, "Minha turma");;

        Aluno primeiroAluno = interfaceGUI.escola.criarAluno("João", "234");

        interfaceGUI.matricular(primeiroAluno, CURSO_PADRAO, primeiraTurma);
        interfaceGUI.exibirStatus(primeiraTurma);
    }
}
