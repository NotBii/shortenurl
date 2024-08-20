package com.example.shortenurlapp.controller;

import com.example.shortenurlapp.dto.ShortenUrlCreateRequestDto;
import com.example.shortenurlapp.dto.ShortenUrlCreateResponseDto;
import com.example.shortenurlapp.dto.ShortenUrlInformationDto;
import com.example.shortenurlapp.service.ShortenUrlService;
import javax.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor

public class ShortenUrlController {

  private final ShortenUrlService shortenUrlService;


  @PostMapping(value = "/shortenUrl")
  public ResponseEntity<ShortenUrlCreateResponseDto> createShortenUrl(@Valid @RequestBody
      ShortenUrlCreateRequestDto shortenUrlCreateRequestDto) {
    ShortenUrlCreateResponseDto responseDto = shortenUrlService.createShortenUrl(shortenUrlCreateRequestDto);

    return ResponseEntity.ok(responseDto);
  }

  @GetMapping(value = "/{shortenUrlKey}")
  public ResponseEntity<?> redirectShortenUrl(@PathVariable String shortenUrlKey) {
    return ResponseEntity.ok(null);
  }

  @GetMapping(value = "/shortenUrl/{shortenUrlKey}")
  public ResponseEntity<ShortenUrlInformationDto> getShortenUrl(@PathVariable String shortenUrlKey) {
    return ResponseEntity.ok(null);
  }
}
