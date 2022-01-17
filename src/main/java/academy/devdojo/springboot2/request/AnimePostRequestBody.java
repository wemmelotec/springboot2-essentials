package academy.devdojo.springboot2.request;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

//essa é uma classe DTO
//Esse post não precisa enviar o ID da entidade, por isso apenas a String
@Data
public class AnimePostRequestBody {
    //essa notação faz a validação do campo, através da biblioteca validation
    //preiso também indicar no controller que eu quero que o @RequestBody seja validado
    @NotEmpty(message = "The anime name cannot be empty")
    private String name;
}
