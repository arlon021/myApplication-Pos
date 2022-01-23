package br.com.cbgomes.response;

import br.com.cbgomes.ports.data.output.HospitalOutputPort;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class HospitalResponse {

    private Long id;
    private String nome;
    private String cnpj;
    private String endereco;
    private Float percentualDeOcupacapo;
    private LocalizacaoResponse localizacao;
    private InventarioResponse inventario;


    public static HospitalResponse converteHospitalOutputPortHospitalResponse(HospitalOutputPort hospitalOutputPort) {

        InventarioResponse inventarioResponse = InventarioResponse.builder()
                .pontosDoInventario(hospitalOutputPort.getInventario().getPontosDoInventario())
                .id(hospitalOutputPort.getId())
                .itemResponse(ItemResponse.itemOutputPortToResponse(hospitalOutputPort.getInventario().getItens()))
                .build();

        LocalizacaoResponse localizacaoOutputPort = LocalizacaoResponse.builder()
                .id(hospitalOutputPort.getLocalizacaoOutputPort().getId())
                .longitude(hospitalOutputPort.getLocalizacaoOutputPort().getLongitude())
                .latitude(hospitalOutputPort.getLocalizacaoOutputPort().getLatitude())
                .build();

        HospitalResponse hospitalResponse = HospitalResponse.builder()
                .id(hospitalOutputPort.getId())
                .nome(hospitalOutputPort.getNome())
                .cnpj(hospitalOutputPort.getCnpj())
                .endereco(hospitalOutputPort.getEndereco())
                .percentualDeOcupacapo(hospitalOutputPort.getPercentualDeOcupacapo())
                .localizacao(localizacaoOutputPort)
                .inventario(inventarioResponse)
                .build();

        return hospitalResponse;
    }
}
