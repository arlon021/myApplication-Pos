package br.com.cbgomes;

import br.com.cbgomes.domain.HospitalEntity;
import br.com.cbgomes.ports.data.input.HospitalInputPort;
import br.com.cbgomes.ports.output.OutputPort;
import br.com.cbgomes.repository.RepositoryPresenter;
import org.springframework.stereotype.Component;

@Component
public class OutputPortImpl implements OutputPort {

    private final RepositoryPresenter repositoryPresenter;

    public OutputPortImpl(RepositoryPresenter repositoryPresenter) {
        this.repositoryPresenter = repositoryPresenter;
    }

    @Override
    public void save(HospitalInputPort hospitalInputPort) {
        this.repositoryPresenter.save(HospitalEntity.converteHospitalEntity(hospitalInputPort));
    }
}
