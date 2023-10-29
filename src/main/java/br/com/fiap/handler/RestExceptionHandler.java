package br.com.fiap.handler;



import br.com.fiap.exception.BadRequestException;
import br.com.fiap.exception.BadRequestExceptionDetails;
import br.com.fiap.exception.ValidationExceptionDetails;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.List;
import java.util.stream.Collectors;

@ControllerAdvice
public class RestExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex) {

        List<FieldError> fieldErrors = ex.getBindingResult().getFieldErrors();
        String fields = fieldErrors.stream().map(FieldError::getField).collect(Collectors.joining(", "));
        String fieldsMessage = fieldErrors.stream().map(FieldError::getDefaultMessage).collect(Collectors.joining(", "));

        return new ResponseEntity<>(ValidationExceptionDetails.builder()
                .status(HttpStatus.BAD_REQUEST.value())
                .title("Bad Request Exception")
                .details("Check the field(s) error")
                .fields(fields)
                .fieldsMessage(fieldsMessage)
                .build(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<BadRequestExceptionDetails> handlerBadRequestException(BadRequestException bre){
        return new ResponseEntity<>(BadRequestExceptionDetails.builder()
                .status(HttpStatus.BAD_REQUEST.value())
                .title("Bad Request Exception, check the Documentation")
                .details(bre.getMessage())
                .build(), HttpStatus.BAD_REQUEST);
    }



}
