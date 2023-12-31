package com.turkcell.solmaya.core.configuration.exceptions;

import com.turkcell.solmaya.common.constants.ExceptionTypes;
import com.turkcell.solmaya.core.exceptions.BusinessException;
import com.turkcell.solmaya.core.utils.results.ExceptionResult;
import jakarta.validation.ValidationException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice //controller'dan gelen tüm hataları dinliyor,hata yakalarsa hata çeşitlerine göre sonuç veriyor
public class RestExceptionHandler {

    @ExceptionHandler
    @ResponseStatus(HttpStatus.BAD_REQUEST) //400
    public ExceptionResult<Object> handleMethodArgumentNotValidException(MethodArgumentNotValidException exception) { //validasyonlar için
        Map<String, String> validationErrors = new HashMap<>();
        for (FieldError fieldError : exception.getBindingResult().getFieldErrors()) {
            validationErrors.put(fieldError.getField(), fieldError.getDefaultMessage());
        }
        return new ExceptionResult<>(ExceptionTypes.Exception.Validation, validationErrors);
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY) //422
    public ExceptionResult<Object> handleValidationException(ValidationException exception) {
        return new ExceptionResult<>(ExceptionTypes.Exception.Validation, exception.getMessage());
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.CONFLICT) //409
    public ExceptionResult<Object> handleDataIntegrityViolation(DataIntegrityViolationException exception) {
        return new ExceptionResult<>(ExceptionTypes.Exception.DataIntegrityViolation, exception.getMessage());
    }

    @ExceptionHandler //hatayı yönetiyor,uzun hata mesajlarından kurtarır
    @ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY) //422
    public ExceptionResult<Object> handleBusinessException(BusinessException exception) {
        return new ExceptionResult<>(ExceptionTypes.Exception.Business, exception.getMessage());
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR) //500
    public ExceptionResult<Object> handleRuntimeException(RuntimeException exception) {
        return new ExceptionResult<>(ExceptionTypes.Exception.Runtime, exception.getMessage());
    }

}
