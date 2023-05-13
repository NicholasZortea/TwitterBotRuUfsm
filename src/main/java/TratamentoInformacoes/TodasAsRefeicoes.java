package TratamentoInformacoes;

import java.util.List;

public class TodasAsRefeicoes {
    private List<Cafes> listaDosCafes;
    private List<Almocos> listaDosAlmocos;
    private List<Jantas> listaDasJantas;

    public List<Cafes> getListaDosCafes() {
        return listaDosCafes;
    }

    public void setListaDosCafes(List<Cafes> listaDosCafes) {
        this.listaDosCafes = listaDosCafes;
    }

    public List<Almocos> getListaDosAlmocos() {
        return listaDosAlmocos;
    }

    public void setListaDosAlmocos(List<Almocos> listaDosAlmocos) {
        this.listaDosAlmocos = listaDosAlmocos;
    }

    public List<Jantas> getListaDasJantas() {
        return listaDasJantas;
    }

    public void setListaDasJantas(List<Jantas> listaDasJantas) {
        this.listaDasJantas = listaDasJantas;
    }
}
