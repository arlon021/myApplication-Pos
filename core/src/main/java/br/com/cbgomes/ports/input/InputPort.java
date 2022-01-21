package br.com.cbgomes.ports.input;

import br.com.cbgomes.ports.data.input.HospitalInputPort;
import org.springframework.stereotype.Component;


public interface InputPort {

    void save(HospitalInputPort hospitalInputPort);
}
