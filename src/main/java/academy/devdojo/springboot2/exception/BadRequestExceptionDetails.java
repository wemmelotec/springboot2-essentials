package academy.devdojo.springboot2.exception;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;
/*
Isso é um Handler global que me permite personalizar os campos que irão retornar nas minhas exceções personalizadas
Vou utilizar esse campos no Handle GLobal em RestExceptionHandler
essa classe foi atualizada para extender o ExceptionDetails
 */
@Getter
@SuperBuilder
public class BadRequestExceptionDetails extends ExceptionDetails{

//    private String title;
//    private int status;
//    private String details;
//    private String developerMessage;
//    private LocalDateTime timestamp;

}
