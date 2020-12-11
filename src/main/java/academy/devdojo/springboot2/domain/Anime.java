package academy.devdojo.springboot2.domain;

public class Anime {
    private String name;
/*
essa sobrecarga no método construtor me permite construir o objeto das duas formas:
-passando a String no parâmetro ou não passando nada.
 */
    public Anime(String name) {
        this.name = name;
    }

    public Anime() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    //essentials 4 do inicio
    //git, parei em repositórios remotos
}
