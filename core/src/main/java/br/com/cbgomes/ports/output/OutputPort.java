package br.com.cbgomes.ports.output;

import br.com.cbgomes.ports.data.input.HospitalInputPort;
import br.com.cbgomes.ports.data.output.HospitalOutputPort;
import org.springframework.stereotype.Component;

import java.util.List;


public interface OutputPort {
    HospitalOutputPort save(HospitalInputPort hospitalInputPort);
    List<HospitalOutputPort> list();
    void atualizarPercentualDeOcupacao(Long hospitalId, Float percentual);
}
