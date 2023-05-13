import DiasDaSemana.DiasDaSemana;
import Requests.RuRequests.RuLoginRequest;
import Requests.RuRequests.RuMenuRequest;
import Requests.TwitterRequest.TwitterPost;
import TratamentoInformacoes.*;
import org.htmlunit.WebClient;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;


import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{


        WebClient webClient = new WebClient();
        RuLoginRequest requisicaoParaLogarRu = new RuLoginRequest(webClient);
        RuMenuRequest requisicaoAoCardapioRU = new RuMenuRequest(webClient);

        requisicaoParaLogarRu.getRequestResponseAsString();

        String corpoHtml = requisicaoAoCardapioRU.getRequestResponseAsString();

        Document document = Jsoup.parse(corpoHtml);


        //cria um arrayList com os dias da semana
        ArrayList<String> listaComOsDiasDaSemana = SeletorDeInformacoes.retornaListaComOsDiasDaSemana(document);

        List <Cafes> listaDosCafes = SeletorDeInformacoes.retornaListaComTodosOsItensDosCafes(document);

        List<Almocos> listaDosAlmocos = SeletorDeInformacoes.retornaListaComTodosOsItensDosAlmocos(document);

        List<Jantas> listaDasJantas = SeletorDeInformacoes.retornaListaComTodosOsItensDasJantas(document);

        TodasAsRefeicoes todasRefeicoes = new TodasAsRefeicoes();
        todasRefeicoes.setListaDosCafes(listaDosCafes);
        todasRefeicoes.setListaDosAlmocos(listaDosAlmocos);
        todasRefeicoes.setListaDasJantas(listaDasJantas);
        //for para preencher a lista dos dias da semana
        List<DiasDaSemana> todosOsDiasDoCalendario = SeletorDeInformacoes.retornaListaDaSemanaComCardapioPreenchido(listaComOsDiasDaSemana, todasRefeicoes);

        for (DiasDaSemana x : todosOsDiasDoCalendario){
            System.out.println(x.returnMenuCafe());
            System.out.println(x.returnMenuAlmoco());
            System.out.println(x.returnMenuJanta());
        }

        TwitterPost postaNoTwitter = new TwitterPost(todosOsDiasDoCalendario);
        postaNoTwitter.post();

    }
    }

