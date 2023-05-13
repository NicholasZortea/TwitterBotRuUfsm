package TratamentoInformacoes;

import java.util.LinkedList;
import java.util.Queue;

public class Almocos {
    private Queue<String> listaDasListasDosAlmocos= new LinkedList<>();

    public Queue<String> getListaDasListasDosAlmocos() {
        return listaDasListasDosAlmocos;
    }

    public void addItemALista(String item) {
        this.listaDasListasDosAlmocos.add(item);
    }
}
