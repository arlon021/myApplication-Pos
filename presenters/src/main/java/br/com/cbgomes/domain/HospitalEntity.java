package br.com.cbgomes.domain;

import br.com.cbgomes.ports.data.input.HospitalInputPort;
import br.com.cbgomes.ports.data.input.ItemInputPort;
import br.com.cbgomes.ports.data.output.HospitalOutputPort;
import br.com.cbgomes.ports.data.output.InventarioOutputPort;
import br.com.cbgomes.ports.data.output.ItemOutputPort;
import br.com.cbgomes.ports.data.output.LocalizacaoOutputPort;
import lombok.*;

import javax.persistence.*;
import java.util.Arrays;
import java.util.List;

@Entity
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class HospitalEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private String cnpj;

    private String endereco;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn ( name = "localizacao_ID" )
    private LocalizacaoEntity localizacao;

    @JoinColumn ( name = "inventario_ID" )
    @OneToOne(cascade = CascadeType.ALL)
    private InventarioEntity inventario;

    private float percentualOcupacao;

    public float atualizaPercentualDeOcupacao(Float percentual){
        return this.percentualOcupacao = percentual;
    }

    public static HospitalEntity converteHospitalEntity(HospitalInputPort inputPort) {

        InventarioEntity inventario = InventarioEntity
                .builder()
                .id(null)
                .itens(Item.itemInputPortToItem(inputPort.getInventario().getItens()))
                .build();
        inventario.calcularPontos();

        LocalizacaoEntity localizacao = LocalizacaoEntity.builder()
                .id(null)
                .latitude(inputPort.getLocalizacao().getLatitude())
                .longitude(inputPort.getLocalizacao().getLongitude())
                .build();

        return HospitalEntity.builder()
                .id(null)
                .nome(inputPort.getNome())
                .cnpj(inputPort.getCnpj())
                .endereco(inputPort.getEndereco())
                .percentualOcupacao(inputPort.getPercentualDeOcupacapo())
                .localizacao(localizacao)
                .inventario(inventario)
                .build();
    }

    public static HospitalOutputPort converteHospitalOutputPort(HospitalEntity hospitalEntity) {

        InventarioOutputPort inventarioOutputPort = InventarioOutputPort.builder()
                .id(hospitalEntity.id)
                .pontosDoInventario(hospitalEntity.getInventario().getPontosDoInventario())
                .itens(Item.itemToOutputPort(hospitalEntity.inventario.getItens()))
                .build();

        LocalizacaoOutputPort localizacaoOutputPort = LocalizacaoOutputPort.builder()
                .id(hospitalEntity.id)
                .latitude(hospitalEntity.getLocalizacao().getLatitude())
                .longitude(hospitalEntity.getLocalizacao().getLongitude())
                .build();

        return HospitalOutputPort.builder()
                .id(hospitalEntity.id)
                .nome(hospitalEntity.getNome())
                .cnpj(hospitalEntity.getCnpj())
                .endereco(hospitalEntity.getEndereco())
                .percentualDeOcupacapo(hospitalEntity.percentualOcupacao)
                .inventario(inventarioOutputPort)
                .localizacaoOutputPort(localizacaoOutputPort)
                .build();
    }
}
