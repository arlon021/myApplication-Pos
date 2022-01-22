package br.com.cbgomes.domain;


import br.com.cbgomes.helper.GerenciaItem;
import lombok.Getter;

@Getter
public enum TipoDoItem implements GerenciaItem {


    MEDICO(3, "Médico") {
        @Override
        public Integer calculaPontosDoItem(Item item) {
            int qtd = item.getQuantidade();
            int pontos = qtd * getValor();
            return pontos;
        }
    };


    public Integer valor;
    public String descricao;

    TipoDoItem(Integer valor, String descricao){
        this.descricao = descricao;
        this.valor = valor;
    }

    public Integer getValor(){
        return this.valor;
    }
}
