package TratamentoInformacoes;

import DiasDaSemana.DiasDaSemana;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.List;

public class SeletorDeInformacoes {



    public static ArrayList<String> retornaListaComOsDiasDaSemana(Document document){
        ArrayList<String> dayOfWeekList = new ArrayList<>();
        Elements diasSemana = document.select("ul.nav.tabs li a");
        for (Element x : diasSemana){
            dayOfWeekList.add(x.text());
        }
        return dayOfWeekList;
    }
    public static ArrayList<Cafes> retornaListaComTodosOsItensDosCafes(Document document){
        ArrayList<Cafes> returnArrayList = new ArrayList<>();

        for (int i = 0; i<=6 ; i++) {//indice vai até 6 pq é o numero máximo de cardápios dispostos no site
            Cafes cafeQueue = new Cafes();
            //selecionar a tabela que possui o thead com o conteúdo "Café"
            Elements tabelaCafe = document.select("div#tab"+i+" div table:has(thead.header tr.info.large-font-size th.padding:matchesOwn(^Café$))");
            //dentro dessa tabela seleciona os elementos com a tag <span> e com as classes "clickable" e "preparo"
            Elements cafe = tabelaCafe.select("span.clickable.preparo");
            for (Element x : cafe) {
                cafeQueue.addItemALista(x.text());
            }
            returnArrayList.add(cafeQueue);
        }

        return returnArrayList;
    }

    public static ArrayList<Almocos> retornaListaComTodosOsItensDosAlmocos(Document document){
        ArrayList<Almocos> returnArrayList = new ArrayList<>();

        for (int i = 0 ;i<=6; i++) {//indice vai até 6 pq é o numero máximo de cardápios dispostos no site
            Almocos almocoQueue = new Almocos();
            //selecionar a tabela que possui o thead com o conteúdo "Almoço"
            Elements tabelaAlmoco = document.select("div#tab"+i+" div table:has(thead.header tr.info.large-font-size th.padding:matchesOwn(^Almoço$))");
            //dentro dessa tabela seleciona os elementos com a tag <span> e com as classes "clickable" e "preparo"
            Elements Almoco = tabelaAlmoco.select("span.clickable.preparo");
            for (Element x : Almoco) {
                almocoQueue.addItemALista(x.text());
            }
            returnArrayList.add(almocoQueue);
        }

        return returnArrayList;
    }

    public static ArrayList<Jantas> retornaListaComTodosOsItensDasJantas(Document document){
        ArrayList<Jantas> returnArrayList = new ArrayList<>();

        for(int i =0; i<=6; i++) {
            Jantas jantaQueue = new Jantas();
            //selecionar a tabela que possui o thead com o conteúdo "Jantar"
            Elements tabelaJanta = document.select("div#tab"+i+" div table:has(thead.header tr.info.large-font-size th.padding:matchesOwn(^Jantar$))");
            //dentro dessa tabela seleciona os elementos com a tag <span> e com as classes "clickable" e "preparo"
            Elements Janta = tabelaJanta.select("span.clickable.preparo");
            for (Element x : Janta) {
                jantaQueue.addItemALista(x.text());
            }
            returnArrayList.add(jantaQueue);
        }

        return returnArrayList;
    }

    public static void preencheArrayComItensDoCafe(DiasDaSemana diaDaSemanaASerAdicionado, List<Cafes> listaDosCafes){
            Cafes cafes = listaDosCafes.remove(0);
                for (String y : cafes.getListaDasListasDosCafes()){
                    diaDaSemanaASerAdicionado.setCafe(y);
                }
        }


    public static void preencheArrayComItensDoAlmoco(DiasDaSemana diaDaSemanaASerAdicionado, List<Almocos> listaDosAlmocos){
        Almocos almocos = listaDosAlmocos.remove(0);
            for (String y : almocos.getListaDasListasDosAlmocos()){
                diaDaSemanaASerAdicionado.setAlmoco(y);
            }

    }

    public static void preencheArrayComItensDoJantar(DiasDaSemana diaDaSemanaASerAdicionado, List<Jantas> listaDasJantas){
        Jantas jantas = listaDasJantas.remove(0);
            for (String y : jantas.getListaDasListasDasJantas()){
                diaDaSemanaASerAdicionado.setJanta(y);
            }
    }

        public static List<DiasDaSemana> retornaListaDaSemanaComCardapioPreenchido(ArrayList<String> daysOfWeekArrayList, TodasAsRefeicoes todasAsRefeicoes){
            List<DiasDaSemana> diasDaSemana = new ArrayList<DiasDaSemana>();

            for (int i =0; i< daysOfWeekArrayList.size(); i++){
                DiasDaSemana diaDaSemanaASerAdicionado = new DiasDaSemana();
                SeletorDeInformacoes.preencheArrayComItensDoCafe(diaDaSemanaASerAdicionado, todasAsRefeicoes.getListaDosCafes());

                SeletorDeInformacoes.preencheArrayComItensDoAlmoco(diaDaSemanaASerAdicionado,todasAsRefeicoes.getListaDosAlmocos());

                SeletorDeInformacoes.preencheArrayComItensDoJantar(diaDaSemanaASerAdicionado,todasAsRefeicoes.getListaDasJantas());

                diaDaSemanaASerAdicionado.setDia(daysOfWeekArrayList.get(i));
                diaDaSemanaASerAdicionado.setDiaMes();
                diasDaSemana.add(diaDaSemanaASerAdicionado);
            }
            return diasDaSemana;
        }
}
