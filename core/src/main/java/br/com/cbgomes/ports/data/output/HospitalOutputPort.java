package br.com.cbgomes.ports.data.output;

import br.com.cbgomes.ports.data.input.InventarioInputPort;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class HospitalOutputPort {

    private Long id;
    private String nome;
    private String cnpj;
    private String endereco;
    private Float percentualDeOcupacapo;
    private LocalizacaoOutputPort localizacaoOutputPort;
    private InventarioOutputPort inventario;

    private float percentualOcupacao;

}
