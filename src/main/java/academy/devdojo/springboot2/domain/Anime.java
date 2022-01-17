package academy.devdojo.springboot2.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

//por estar utilizando o lombok eu não preciso criar get e setters, equals, hashcode, to string basta anotar a classe com o Data
@Data
@AllArgsConstructor //para gerar um construtor com todos esse valores
@NoArgsConstructor
@Entity
@Table(name = "tb_anime")
@Builder//para poder utilizar o builder em outras classes e instaciar o objeto em outro local
public class Anime {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
}
