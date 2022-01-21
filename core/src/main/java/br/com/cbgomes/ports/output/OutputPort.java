package br.com.cbgomes.ports.output;

import br.com.cbgomes.ports.data.input.HospitalInputPort;
import org.springframework.stereotype.Component;


public interface OutputPort {
    void save(HospitalInputPort hospitalInputPort);
}
