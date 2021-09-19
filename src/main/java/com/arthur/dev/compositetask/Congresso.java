package com.arthur.dev.compositetask;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Congresso {

    private List<Participante> participantes;

    private final Integer totalAssentos;

    public Congresso(Integer totalAssentos) {
        this.participantes = new ArrayList<>();
        this.totalAssentos = totalAssentos;
    }

    public Integer getTotalParticipantes() {
        return this.participantes.size();
    }

    public List<Participante> getParticipantes() {
        return participantes;
    }

    public void setParticipantes(List<Participante> participantes) {
        this.participantes = participantes;
    }

    public Integer getTotalAssentos() {
        return totalAssentos;
    }

    public void adicionarParticipante(Participante i) throws Exception {
        Optional<Participante> participanteOcupandoAssento =
                this.participantes.stream().map(Participante::getAfiliados).flatMap(Collection::stream)
                .filter(participante -> participante.getAssento().equals(i.getAssento())).findFirst();
        if (participanteOcupandoAssento.isPresent() && !participanteOcupandoAssento.get().getAssento().equals(AssentosEspeciais.INSTITUICAO.value)) {
            throw new Exception("Esse assento já está ocupado");
        }
        this.participantes.add(i);
    }

    public static void main(String[] args) throws Exception {
        Congresso congresso = new Congresso(20);

        Participante p1 = new Individuo(1);

        congresso.adicionarParticipante(p1);

        Participante p2 = new Instituicao();
        Participante p3 = new Individuo(3);
        Participante p4 = new Individuo(4);

        p2.addParticipante(p3);
        p2.addParticipante(p4);

        congresso.adicionarParticipante(p2);

        System.out.println(congresso.getParticipantes());

        Participante p5 = new Individuo(5);

        try {
            p4.addParticipante(p5);
        } catch (Exception e) {
            e.printStackTrace();
        }

        Participante pp3 = new Individuo(3);
        try {
            congresso.adicionarParticipante(pp3);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
