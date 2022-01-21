package br.com.cbgomes.domain;

import br.com.cbgomes.ports.data.input.HospitalInputPort;
import lombok.*;

import javax.persistence.*;

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

    @OneToOne
    @JoinColumn ( name = "localizacao_ID" )
    private LocalizacaoEntity localizacao;


    public static HospitalEntity converteHospitalEntity(HospitalInputPort inputPort) {

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
                .localizacao(localizacao)
                .build();

    }
}
