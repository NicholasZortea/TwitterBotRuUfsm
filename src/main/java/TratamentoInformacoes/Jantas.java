package TratamentoInformacoes;

import java.util.LinkedList;
import java.util.Queue;

public class Jantas {
    private Queue<String> listaDasListasDasJantas= new LinkedList<>();

    public Queue<String> getListaDasListasDasJantas() {
        return listaDasListasDasJantas;
    }

    public void addItemALista(String item) {
        this.listaDasListasDasJantas.add(item);
    }
}
