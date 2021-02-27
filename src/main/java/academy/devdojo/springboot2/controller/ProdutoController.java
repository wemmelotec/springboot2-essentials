package academy.devdojo.springboot2.controller;

import academy.devdojo.springboot2.domain.Produto;
import academy.devdojo.springboot2.request.ProdutoPostRequestBody;
import academy.devdojo.springboot2.service.ProdutoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("produtos")
@RequiredArgsConstructor
public class ProdutoController {
    private final ProdutoService produtoService;

    @GetMapping
    public ResponseEntity<List<Produto>> list(){
        return ResponseEntity.ok(produtoService.listAll());
    }
    @PostMapping
    public ResponseEntity<Produto> save(@RequestBody ProdutoPostRequestBody produtoPostRequestBody){
        return new ResponseEntity<>(produtoService.save(produtoPostRequestBody), HttpStatus.CREATED);
    }
}
