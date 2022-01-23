package br.com.cbgomes.request;

import br.com.cbgomes.ports.data.input.HospitalInputPort;
import br.com.cbgomes.ports.data.input.InventarioInputPort;
import br.com.cbgomes.ports.data.input.LocalizacaoInputPort;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class HospitalRequest {

    private String nome;
    private String cnpj;
    private String endereco;
    private Float percentualDeOcupacao;
    private LocalizacaoRequest localizacao;
    private InventarioRequest inventario;


    public HospitalInputPort convertHospitalInputPort(HospitalRequest request) {

        InventarioInputPort inventarioInputPort = InventarioInputPort.builder()
                .itens(ItemRequest.itemRequestToItemInputPort(request.getInventario().getItens()))
                .build();

        LocalizacaoInputPort localizacaoInputPort = LocalizacaoInputPort.builder()
                .latitude(request.localizacao.getLatitude())
                .longitude(request.localizacao.getLongitude())
                .build();

        return HospitalInputPort.builder()
                .cnpj(request.cnpj)
                .nome(request.nome)
                .endereco(request.endereco)
                .percentualDeOcupacapo(request.percentualDeOcupacao)
                .localizacao(localizacaoInputPort)
                .inventario(inventarioInputPort)
                .build();
    }
}
