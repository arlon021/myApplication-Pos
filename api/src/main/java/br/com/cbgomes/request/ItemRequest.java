package br.com.cbgomes.request;

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
public class ItemRequest {

    private int quantidade;
    private String tipoItem;

    public static List<ItemInputPort> itemRequestToItemInputPort(List<ItemRequest> itens){
        List<ItemInputPort> inList = new LinkedList<>();
        itens.forEach(item -> {
            ItemInputPort itemInputPort = ItemInputPort.builder()
                    .tipoDoItem(item.getTipoItem())
                    .quantidade(item.getQuantidade())
                    .build();
            inList.add(itemInputPort);
        });
        return inList;
    }
}
