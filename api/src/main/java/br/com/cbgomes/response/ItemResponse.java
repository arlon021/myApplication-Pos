package br.com.cbgomes.response;

import br.com.cbgomes.ports.data.output.ItemOutputPort;
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
public class ItemResponse {

    private Long id;
    private Integer quantidade;
    private String tipoDoItem;

    public static List<ItemResponse> itemOutputPortToResponse(List<ItemOutputPort> itens) {
        List<ItemResponse> itemResponseList = new LinkedList<>();
        itens.forEach(itemOutputPort -> {
            ItemResponse item = ItemResponse.builder()
                    .id(itemOutputPort.getId())
                    .tipoDoItem(itemOutputPort.getTipoDoItem())
                    .quantidade(itemOutputPort.getQuantidade())
                    .build();
            itemResponseList.add(item);
        });
        return itemResponseList;

    }
}
