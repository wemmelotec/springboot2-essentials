package academy.devdojo.springboot2.exception;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
/*
Isso é um Handler global que me permite personalizar os campos que irão retornar nas minhas exceções personalizadas
Vou utilizar esse campos no Handle GLobal em RestExceptionHandler
 */
@Data
@Builder
public class BadRequestExceptionDetails {

    private String title;
    private int status;
    private String details;
    private String developerMessage;
    private LocalDateTime timestamp;
}
