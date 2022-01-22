package br.com.cbgomes.ports.input;

import br.com.cbgomes.ports.data.input.HospitalInputPort;
import br.com.cbgomes.ports.data.output.HospitalOutputPort;

import java.util.List;


public interface InputPort {

    HospitalOutputPort save(HospitalInputPort hospitalInputPort);

    List<HospitalOutputPort> list();

    void atualizarPercentualDeOcupacao(Long hospitalId, Float percentual);
}
