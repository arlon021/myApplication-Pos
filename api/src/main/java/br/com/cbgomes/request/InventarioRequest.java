package br.com.cbgomes.request;

import br.com.cbgomes.ports.data.input.InventarioInputPort;
import br.com.cbgomes.ports.data.input.ItemInputPort;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.LinkedList;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class InventarioRequest {

    private List<ItemRequest> itens;

}
