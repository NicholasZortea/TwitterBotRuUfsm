package TratamentoInformacoes;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Cafes {
    private Queue<String> listaDasListasDosCafes = new LinkedList<>();

    public Queue<String> getListaDasListasDosCafes() {
        return listaDasListasDosCafes;
    }

    public void addItemALista(String item) {
        this.listaDasListasDosCafes.add(item);
    }
}
