package br.com.cbgomes.ports.input;

import br.com.cbgomes.ports.data.input.HospitalInputPort;
import br.com.cbgomes.ports.data.output.HospitalOutputPort;


public interface InputPort {
    HospitalOutputPort save(HospitalInputPort hospitalInputPort);
}
