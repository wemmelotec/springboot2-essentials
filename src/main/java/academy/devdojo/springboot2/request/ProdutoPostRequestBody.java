package academy.devdojo.springboot2.request;

import lombok.Data;

@Data
public class ProdutoPostRequestBody {
    private String nome;
    private int quantidade;
}
