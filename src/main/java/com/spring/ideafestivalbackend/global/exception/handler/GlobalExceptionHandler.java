package com.spring.ideafestivalbackend.global.exception.handler;

import com.spring.ideafestivalbackend.domain.auth.exception.BlackListAlreadyExistException;
import com.spring.ideafestivalbackend.domain.auth.exception.RefreshTokenNotFoundException;
import com.spring.ideafestivalbackend.domain.auth.exception.WrongPasswordException;
import com.spring.ideafestivalbackend.domain.email.exception.MailAuthCodeExpiredException;
import com.spring.ideafestivalbackend.domain.email.exception.ManyRequestEmailAuthException;
import com.spring.ideafestivalbackend.domain.email.exception.NotMatchAuthCodeException;
import com.spring.ideafestivalbackend.domain.user.exception.UserNotFoundException;
import com.spring.ideafestivalbackend.global.exception.ErrorResponse;
import com.spring.ideafestivalbackend.global.exception.TokenNotValidException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;

@Slf4j
@RestControllerAdvice
@Order(Ordered.HIGHEST_PRECEDENCE)
public class GlobalExceptionHandler {

    @ExceptionHandler(MailAuthCodeExpiredException.class)
    public ResponseEntity<ErrorResponse> DuplicateMemberExceptionHandler(HttpServletRequest request, MailAuthCodeExpiredException ex) {
        printError(request, ex, ex.getErrorCode().getMessage());
        ErrorResponse errorResponse = new ErrorResponse(ex.getErrorCode().getMessage(), ex.getErrorCode().getStatus());
        return new ResponseEntity<>(errorResponse, HttpStatus.valueOf(ex.getErrorCode().getStatus()));
    }

    @ExceptionHandler(RefreshTokenNotFoundException.class)
    public ResponseEntity<ErrorResponse> RefreshTokenNotFoundException(RefreshTokenNotFoundException exception){
        ErrorResponse errorResponse = new ErrorResponse(exception.getErrorCode().getMessage(), exception.getErrorCode().getStatus());
        return new ResponseEntity<>(errorResponse, HttpStatus.valueOf(exception.getErrorCode().getStatus()));
    }

    @ExceptionHandler(TokenNotValidException.class)
    public ResponseEntity<ErrorResponse> handleTokenNotValidException(HttpServletRequest request, TokenNotValidException ex) {
        printError(request, ex, ex.getErrorCode().getMessage());
        ErrorResponse errorResponse = new ErrorResponse(ex.getErrorCode().getMessage(), ex.getErrorCode().getStatus());
        return new ResponseEntity<>(errorResponse, HttpStatus.valueOf(ex.getErrorCode().getStatus()));
    }

    @ExceptionHandler(ManyRequestEmailAuthException.class)
    public ResponseEntity<ErrorResponse> ManyRequestEmailAuthException (ManyRequestEmailAuthException exception){
        ErrorResponse errorResponse = new ErrorResponse(exception.getErrorCode().getMessage(), exception.getErrorCode().getStatus());
        return new ResponseEntity<>(errorResponse, HttpStatus.valueOf(exception.getErrorCode().getStatus()));
    }

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<ErrorResponse> UserNotFoundException (UserNotFoundException exception){
        ErrorResponse errorResponse = new ErrorResponse(exception.getErrorCode().getMessage(), exception.getErrorCode().getStatus());
        return new ResponseEntity<>(errorResponse, HttpStatus.valueOf(exception.getErrorCode().getStatus()));
    }

    @ExceptionHandler(NotMatchAuthCodeException.class)
    public ResponseEntity<ErrorResponse> AuthCodeMisMatchException (NotMatchAuthCodeException exception){
        ErrorResponse errorResponse = new ErrorResponse(exception.getErrorCode().getMessage(), exception.getErrorCode().getStatus());
        return new ResponseEntity<>(errorResponse, HttpStatus.valueOf(exception.getErrorCode().getStatus()));
    }

    @ExceptionHandler(BlackListAlreadyExistException.class)
    public ResponseEntity<ErrorResponse> AccessTokenAlreadyExist(BlackListAlreadyExistException exception){
        ErrorResponse errorResponse = new ErrorResponse(exception.getErrorCode().getMessage(),exception.getErrorCode().getStatus());
        return new ResponseEntity<>(errorResponse, HttpStatus.valueOf(exception.getErrorCode().getStatus()));
    }

    @ExceptionHandler(WrongPasswordException.class)
    public ResponseEntity<ErrorResponse> PasswordWrong(WrongPasswordException exceptin) {
        ErrorResponse errorResponse = new ErrorResponse(exceptin.getErrorCode().getMessage(), exceptin.getErrorCode().getStatus());
        return new ResponseEntity<>(errorResponse, HttpStatus.valueOf(exceptin.getErrorCode().getStatus()));
    }



    private void printError(HttpServletRequest request, RuntimeException ex, String message) {
        log.error(request.getRequestURI());
        log.error(message);
        ex.printStackTrace();
    }

}
