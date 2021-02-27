package academy.devdojo.springboot2.mapper;

import academy.devdojo.springboot2.domain.Anime;
import academy.devdojo.springboot2.request.AnimePostRequestBody;
import academy.devdojo.springboot2.request.AnimePutRequestBody;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/*
ela está sendo utilizada primeiro no service (save, replace)
 */
@Mapper(componentModel = "spring")//essa notação me possibilita fazer injeção de dependência
public abstract class AnimeMapper {
    //este método foi implementado para que eu consiga chamar os dois métodos abstracts abaixo
    public static final AnimeMapper INSTANCE = Mappers.getMapper(AnimeMapper.class);

    //esses dois métodos convertem AnimePostRequestBody e o AnimePutRequestBody para Anime
    public abstract Anime toAnime(AnimePostRequestBody animePostRequestBody);
    public abstract Anime toAnime(AnimePutRequestBody animePutRequestBody);
}
