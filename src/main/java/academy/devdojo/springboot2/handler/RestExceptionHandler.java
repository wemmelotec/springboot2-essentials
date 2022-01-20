package academy.devdojo.springboot2.handler;

import academy.devdojo.springboot2.exception.BadRequestException;
import academy.devdojo.springboot2.exception.BadRequestExceptionDetails;
import academy.devdojo.springboot2.exception.ExceptionDetails;
import academy.devdojo.springboot2.exception.ValidationExceptionDetails;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.Nullable;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import org.springframework.web.util.WebUtils;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;
//eu posso ter diversos tipos de exceção nesta classe

@ControllerAdvice //informa ao controller a respeito das exceções que estiverem aqui
//extender a classe ResponseEntityExceptionHandler que já tem o tratamento para várias exceções
//e sobrescrever esses métodos personalizando
public class RestExceptionHandler extends ResponseEntityExceptionHandler {
    //caso eu tenha uma exceção desse tipo BadRequestException, o controller deve retornar o método abaixo BadRequestExceptionDetails
    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<BadRequestExceptionDetails> handleBadRequestException(BadRequestException badRequestException){
        return new ResponseEntity<>(
                BadRequestExceptionDetails.builder() //instanciei o objeto com o builder
                    .timestamp(LocalDateTime.now())
                        .status(HttpStatus.BAD_REQUEST.value())
                        .title("Bad Request Exception, check the documentation")
                        .details(badRequestException.getMessage())
                        .developerMessage(badRequestException.getClass().getName())
                        .build(), HttpStatus.BAD_REQUEST);
    }

    //quando o spring lançar essa exceção MethodArgumentNotValidException
    //quem vai tratar ela será a ValidationExceptionDetails
//    @ExceptionHandler(MethodArgumentNotValidException.class)
//    public ResponseEntity<ValidationExceptionDetails> handlerMethodArgumentNotValidException
//    (MethodArgumentNotValidException methodArgumentNotValidException)
    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(
            MethodArgumentNotValidException exception, HttpHeaders headers, HttpStatus status, WebRequest request){
        //pegou os campos de erros do tipo e criou uma lista
        List<FieldError> fieldErrors = exception.getBindingResult().getFieldErrors();
        //já peguei os campos de erros agora vou pegar as mensagens
        String fields = fieldErrors.stream().map(FieldError::getField).collect(Collectors.joining(", "));
        //agora vou pegar as mensagens
        String fieldsMessage = fieldErrors.stream().map(FieldError::getDefaultMessage).collect(Collectors.joining(", "));

        return new ResponseEntity<>(
                ValidationExceptionDetails.builder() //instanciei o objeto com o builder
                        .timestamp(LocalDateTime.now())
                        .status(HttpStatus.BAD_REQUEST.value())
                        .title("Bad Request Exception, invalid fields")
                        .details("Check the field(s) error")
                        .developerMessage(exception.getClass().getName())
                        .fields(fields)
                        .fieldsMessage(fieldsMessage)
                        .build(), HttpStatus.BAD_REQUEST);
    }

    //esse método já foi sobrescrito por eu ter extendido a classe ResponseEntityExceptionHandler
    @Override
    protected ResponseEntity<Object> handleExceptionInternal(
            Exception ex, @Nullable Object body, HttpHeaders headers, HttpStatus status, WebRequest request) {

        ExceptionDetails exceptionDetails = ExceptionDetails.builder()
                .timestamp(LocalDateTime.now())
                .status(status.value())
                .title(ex.getCause().getMessage())
                .details(ex.getMessage())
                .developerMessage(ex.getClass().getName())
                .build();
        return new ResponseEntity<>(exceptionDetails, headers, status);
    }

}
