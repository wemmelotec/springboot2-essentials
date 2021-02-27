package academy.devdojo.springboot2.mapper;

import academy.devdojo.springboot2.domain.Produto;
import academy.devdojo.springboot2.request.ProdutoPostRequestBody;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
@Mapper(componentModel = "spring")
public abstract class ProdutoMapper {
    public static final ProdutoMapper INSTANCE = Mappers.getMapper(ProdutoMapper.class);
    public abstract Produto toProduto(ProdutoPostRequestBody produtoPostRequestBody);
}
