package academy.devdojo.springboot2.service;

import academy.devdojo.springboot2.domain.Anime;
import org.springframework.stereotype.Service;

import java.util.List;

/*
Essa é a classe responsável pelas regras de negócio
 */
@Service//torna a classe um spring been
public class AnimeService {
    public List<Anime> listAll(){
        return List.of(new Anime(1L,"dbz"), new Anime(2L,"treta"));
    }
}
