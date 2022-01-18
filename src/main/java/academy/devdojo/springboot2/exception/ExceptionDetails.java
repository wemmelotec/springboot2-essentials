package academy.devdojo.springboot2.exception;

import lombok.Data;
import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;

//essa classe vai trabalhar as exceção gerais
//e todas as outras pois eu vou atualizar a BadRequestExceptionDetails
@Data
@SuperBuilder //para poder extender na BadRequestExceptionDetails sem problemas com o builder
public class ExceptionDetails {
    protected String title;
    protected int status;
    protected String details;
    protected String developerMessage;
    protected LocalDateTime timestamp;
}
