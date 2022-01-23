package br.com.cbgomes.ports.data.input;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ItemInputPort {

    private int quantidade;

    private Integer pontosDoItem;

    private String tipoDoItem;
}
