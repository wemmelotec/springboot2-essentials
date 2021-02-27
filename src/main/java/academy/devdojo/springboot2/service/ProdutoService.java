package academy.devdojo.springboot2.service;

import academy.devdojo.springboot2.domain.Produto;
import academy.devdojo.springboot2.mapper.ProdutoMapper;
import academy.devdojo.springboot2.repository.ProdutoRepository;
import academy.devdojo.springboot2.request.ProdutoPostRequestBody;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProdutoService {
    private final ProdutoRepository produtoRepository;

    public List<Produto> listAll(){
        return produtoRepository.findAll();
    }

    public Produto save(ProdutoPostRequestBody produtoPostRequestBody) {
        return produtoRepository.save(ProdutoMapper.INSTANCE.toProduto(produtoPostRequestBody));
    }
}
