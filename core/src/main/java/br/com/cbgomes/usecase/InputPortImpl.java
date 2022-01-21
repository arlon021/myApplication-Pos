package br.com.cbgomes.usecase;

import br.com.cbgomes.ports.data.input.HospitalInputPort;
import br.com.cbgomes.ports.input.InputPort;
import br.com.cbgomes.ports.output.OutputPort;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class InputPortImpl implements InputPort {

    private final OutputPort outputPort;

    public InputPortImpl(OutputPort outputPort) {
        this.outputPort = outputPort;
    }

    @Override
    public void save(HospitalInputPort hospitalInputPort) {

    }
}
