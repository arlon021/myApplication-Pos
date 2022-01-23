package br.com.cbgomes.ports.data.output;

import br.com.cbgomes.ports.data.input.ItemInputPort;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class InventarioOutputPort {

    private Long id;
    private Integer pontosDoInventario = 0;
    private List<ItemOutputPort> itens;
}
