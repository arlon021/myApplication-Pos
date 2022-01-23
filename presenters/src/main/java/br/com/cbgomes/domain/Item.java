package br.com.cbgomes.domain;

import br.com.cbgomes.ports.data.input.ItemInputPort;
import br.com.cbgomes.ports.data.output.ItemOutputPort;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.LinkedList;
import java.util.List;

@Entity
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Item {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;

    private int quantidade;

    private Integer pontosDoItem;

    private TipoDoItem tipoDoItem;

    public static List<Item> itemInputPortToItem(List<ItemInputPort> inputPortList){
        List<Item> itens = new LinkedList<>();
        for(ItemInputPort list: inputPortList){
            Item item = Item.builder()
                    .tipoDoItem(TipoDoItem.valueOf(list.getTipoDoItem()))
                    .quantidade(list.getQuantidade())
                    .build();
            itens.add(item);
        }
        return itens;
    }
    public static List<ItemOutputPort> itemToOutputPort(List<Item> itens){
        List<ItemOutputPort> outPorts = new LinkedList<>();
        itens.forEach(item -> {
            ItemOutputPort itemOutputPort = ItemOutputPort.builder()
                    .quantidade(item.getQuantidade())
                    .tipoDoItem(item.tipoDoItem.getDescricao())
                    .id(item.getId())
                    .build();
        });
        return outPorts;
    }

}
