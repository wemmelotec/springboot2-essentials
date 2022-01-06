package academy.devdojo.springboot2.repository;

import academy.devdojo.springboot2.domain.Anime;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AnimeRepository extends JpaRepository<Anime, Long> {

    /*
    Essa primeira consulta utiliza palavras chaves que são entendidas pela JPA e transformadas em uma Query utilizando o JPQL
    jpa documentation https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#jpa.query-methods
    sintaxe:
    findBy - palavra chave
    Name - nome do atributo a ser pesquisado no objeto
    IgnoreCase - palavra chave
    Na segunda consulta eu fiz com a Query explicita
     */
    List<Anime> findByNameIgnoreCase(String name);

    @Query("SELECT obj FROM Anime obj ORDER BY obj.name")
    List<Anime> findByNameOrder();
}
