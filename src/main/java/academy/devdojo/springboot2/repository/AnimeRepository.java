package academy.devdojo.springboot2.repository;

import academy.devdojo.springboot2.domain.Anime;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AnimeRepository extends JpaRepository<Anime, Long> {

    /*
    Essa consulta utiliza palavras chaves que são entendidas pela JPA e transformadas em uma Query utilizando o JPQL
    jpa documentation https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#jpa.query-methods
    sintaxe:
    findBy - palavra chave
    Name - nome do atributo a ser pesquisado no objeto
    IgnoreCase - palavra chave
     */
    List<Anime> findByNameIgnoreCase(String name);
}
