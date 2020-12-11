package academy.devdojo.springboot2.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

//por estar utilizando o lombok eu não preciso criar get e setters, equals, hashcode, to string basta anotar a classe com o Date
@Data
@AllArgsConstructor //para gerar um construtor com todos esse valores
public class Anime {
    private Long id;
    private String name;
/*
essa sobrecarga no método construtor me permite construir o objeto das duas formas:
-passando a String no parâmetro ou não passando nada.
*/
/*
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
*/
}
