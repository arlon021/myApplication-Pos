package br.com.cbgomes;

import br.com.cbgomes.domain.HospitalEntity;
import br.com.cbgomes.ports.data.input.HospitalInputPort;
import br.com.cbgomes.ports.data.output.HospitalOutputPort;
import br.com.cbgomes.ports.output.OutputPort;
import br.com.cbgomes.repository.RepositoryPresenter;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class OutputPortImpl implements OutputPort {

    private final RepositoryPresenter repositoryPresenter;

    public OutputPortImpl(RepositoryPresenter repositoryPresenter) {
        this.repositoryPresenter = repositoryPresenter;
    }

    @Override
    public HospitalOutputPort save(HospitalInputPort hospitalInputPort) {
      var entity = this.repositoryPresenter.save(HospitalEntity.converteHospitalEntity(hospitalInputPort));
      return HospitalEntity.converteHospitalOutputPort(entity);
    }

    @Override
    public List<HospitalOutputPort> list() {
        return this.repositoryPresenter
                .findAll()
                .stream()
                .map(HospitalEntity::converteHospitalOutputPort)
                .collect(Collectors.toList());
    }

    @Override
    public void atualizarPercentualDeOcupacao(Long hospitalId, Float percentual) {
       var hospitalEntity = this.repositoryPresenter.getById(hospitalId);
       var hospitalAtualizado = hospitalEntity.atualizaPercentualDeOcupacao(percentual);
       this.repositoryPresenter.save(hospitalEntity);
    }
}
