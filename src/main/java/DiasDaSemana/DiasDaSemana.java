package DiasDaSemana;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DiasDaSemana {
    private String dia;
    private int diaMes;
    private ArrayList<String> cafe = new ArrayList<>();

    private ArrayList<String> almoco = new ArrayList<>();
    private ArrayList<String> janta = new ArrayList<>();

    public String getDia() {
        return dia;
    }

    public void setDia(String dia) {
        this.dia = dia;
    }

    public ArrayList<String> getCafe() {
        return cafe;
    }

    public void setCafe(String cafe) {
        this.cafe.add(cafe);
    }

    public ArrayList<String> getAlmoco() {
        return almoco;
    }

    public void setAlmoco(String almoco) {
        this.almoco.add(almoco);
    }

    public ArrayList<String> getJanta() {
        return janta;
    }

    public void setJanta(String janta) {
        this.janta.add(janta);
    }

    public String returnMenuCafe(){
        StringBuilder tweetBody = new StringBuilder();
        tweetBody.append("Dia da semana:\n" + this.getDia()+"\n\n");
        tweetBody.append("CAFE: \n");
        removeTemperosDaLista(this.getCafe());
        for (int i =0; i<this.cafe.size(); i++){
            tweetBody.append(this.getCafe().get(i)+"\n");
        }
        return tweetBody.toString();
    }
    public String returnMenuAlmoco(){
        StringBuilder tweetBody = new StringBuilder();
        tweetBody.append("ALMOCO: \n");
        removeTemperosDaLista(this.getAlmoco());
        for (int i =0; i<this.almoco.size(); i++){
            tweetBody.append(this.getAlmoco().get(i)+"\n");
        }
        return tweetBody.toString();
    }
    public String returnMenuJanta(){
        removeTemperosDaLista(this.getJanta());
        StringBuilder tweetBody = new StringBuilder();
        tweetBody.append("JANTA:\n");
        for (int i =0; i<this.janta.size(); i++){
            tweetBody.append(this.getJanta().get(i)+"\n");
        }
        return tweetBody.toString();
    }

    public void setDiaMes() {
        this.diaMes = Integer.parseInt(this.dia.substring(this.dia.length()-5, this.dia.length()-3));
    }

    public int getDiaMes() {
        return diaMes;
    }

    //para remover a String de TEMPEROS, devido a quantidade de caracteres que nao sao uteis no cardapio
    public void removeTemperosDaLista(ArrayList<String> arraySended){
        for (int i=0; i<arraySended.size(); i++){
            Pattern pattern = Pattern.compile("^TEMPEROS");
            Matcher matcher = pattern.matcher(arraySended.get(i));
            if (matcher.find()){
                arraySended.remove(i);
            }
        }
    }
}
