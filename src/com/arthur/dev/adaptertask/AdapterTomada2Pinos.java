package com.arthur.dev.adaptertask;

import com.katyusco.padroes.adpater.servicos.Fio;
import com.katyusco.padroes.adpater.servicos.ServicoTomada3Pinos;

public class AdapterTomada2Pinos extends ServicoTomada3Pinos {


    public AdapterTomada2Pinos(Fio fioVermelho, Fio fioAzulClaro) {
        super(fioVermelho, fioAzulClaro, null);
    }

    @Override
    public void forneceEnergia() {
        System.out.println("CUIDADO!! Esta tomada não é aterrada.");
        super.forneceEnergia();
    }
}
