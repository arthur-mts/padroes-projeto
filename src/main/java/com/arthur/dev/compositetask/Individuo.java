package com.arthur.dev.compositetask;

import java.util.List;

// ENTIDADE FOLHA
public class Individuo extends Participante{
    public Individuo(Integer assento) {
        super(assento);
    }

    @Override
    public List<Participante> getAfiliados() {
        return List.of(this);
    }

    @Override
    public void addParticipante(Participante p) {
        throw new UnsupportedOperationException("Não é possível adicionar filhos em uma entidade folha!");
    }
}
