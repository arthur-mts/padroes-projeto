package com.arthur.dev.compositetask;

import java.util.ArrayList;
import java.util.List;

public abstract class Participante {
    private Integer assento;
    private List<Participante> afiliados;

    public Participante(Integer assento) {
        this.assento = assento;
        this.afiliados = new ArrayList<>();
    }

    public Integer getAssento() {
        return assento;
    }

    public void setAssento(Integer assento) {
        this.assento = assento;
    }

    public List<Participante> getAfiliados() {
        return afiliados;
    }

    public void addParticipante(Participante p) {
        this.afiliados.add(p);
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName() + "(" + this.getAssento() + ")";
    }
}
