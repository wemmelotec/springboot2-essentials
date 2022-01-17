package academy.devdojo.springboot2.service;

import academy.devdojo.springboot2.domain.Anime;
import academy.devdojo.springboot2.exception.BadRequestException;
import academy.devdojo.springboot2.mapper.AnimeMapper;
import academy.devdojo.springboot2.repository.AnimeRepository;
import academy.devdojo.springboot2.request.AnimePostRequestBody;
import academy.devdojo.springboot2.request.AnimePutRequestBody;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/*
Essa é a classe responsável pelas regras de negócio
 */
@Service//torna a classe um spring been
@RequiredArgsConstructor//para o spring fazer a injeção de dependência do animeRepository
public class AnimeService {
    /*private static List<Anime> animes;
    static {
        animes = new ArrayList<>(List.of(new Anime(1L, "dbz"), new Anime(2L, "treta")));
    }*/

    private final AnimeRepository animeRepository;

    public List<Anime> listAll() {
        return animeRepository.findAll();
    }

    public List<Anime> listAllOrderByName() {
        return animeRepository.findByNameOrder();
    }

    public List<Anime> findByName(String name) {
        return animeRepository.findByNameIgnoreCase(name);
    }

    public Anime findByIdOrThrowBadRequestException(long id) {
        return animeRepository.findById(id)
                                    // Exceção personalizada
                .orElseThrow(() -> new BadRequestException("Anime not found"));
                                    // ResponseStatusException(HttpStatus.BAD_REQUEST, "Anime not found"));
    }
    //essa notação serve para garantir que só salvará no banco quando o método finalizar
    @Transactional
    public Anime save(AnimePostRequestBody animePostRequestBody) {
        return animeRepository.save(AnimeMapper.INSTANCE.toAnime(animePostRequestBody));
    }

    public void delete(long id) {
        animeRepository.delete(findByIdOrThrowBadRequestException(id));
    }

    public Anime replace(AnimePutRequestBody animePutRequestBody) {
        Anime savedAnime = findByIdOrThrowBadRequestException(animePutRequestBody.getId());
        Anime anime = AnimeMapper.INSTANCE.toAnime(animePutRequestBody);
        anime.setId(savedAnime.getId());
        return animeRepository.save(anime);
    }
}
