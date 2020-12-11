package academy.devdojo.springboot2.controller;

import academy.devdojo.springboot2.domain.Anime;
import academy.devdojo.springboot2.service.AnimeService;
import academy.devdojo.springboot2.util.DateUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.List;

/*
Lógica de negócio não fica nessa classe controller
 */
@RestController
@RequestMapping("animes")
@Log4j2
@RequiredArgsConstructor//anotação para injetar depencias com o seu construtor sem precisar do Autowired
public class AnimeController {

    //@Autowired
    private final DateUtil dateUtil;
    private final AnimeService animeService;

    @GetMapping(path = "list")
    public List<Anime> list(){
        log.info(dateUtil.formatLocalDateTimeToDatebaseStyle(LocalDateTime.now()));
        return animeService.listAll();
    }
}
