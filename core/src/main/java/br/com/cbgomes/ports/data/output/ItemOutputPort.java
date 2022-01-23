package br.com.cbgomes.ports.data.output;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ItemOutputPort {

    private Long id;
    private int quantidade;
    private Integer pontosDoItem;
    private String tipoDoItem;
}
