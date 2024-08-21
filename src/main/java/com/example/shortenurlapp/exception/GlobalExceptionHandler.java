package com.example.shortenurlapp.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

  @ExceptionHandler(NotFoundShortenUrl.class)
  public ResponseEntity<String> handleNotFoundShortUrl(NotFoundShortenUrl ex) {
    return new ResponseEntity<>("존재하지 않는 단축 url", HttpStatus.NOT_FOUND);
  }

  @ExceptionHandler(LackOfShortenUrlKey.class)
  public ResponseEntity<String> LackOfShortenUrlKey(LackOfShortenUrlKey ex) {
    return new ResponseEntity<>("할당가능한 url이 없습니다.", HttpStatus.INTERNAL_SERVER_ERROR);
  }

}
