package academy.devdojo.springboot2.request;

import lombok.Data;
//essa é uma classe DTO
//Esse post não precisa enviar o ID da entidade, por isso apenas a String
@Data
public class AnimePostRequestBody {
    private String name;
}
