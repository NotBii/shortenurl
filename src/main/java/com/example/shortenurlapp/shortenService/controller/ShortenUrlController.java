package com.example.shortenurlapp.shortenService.controller;

import com.example.shortenurlapp.shortenService.dto.ShortenUrlCreateRequestDto;
import com.example.shortenurlapp.shortenService.dto.ShortenUrlCreateResponseDto;
import com.example.shortenurlapp.shortenService.dto.ShortenUrlInformationDto;
import com.example.shortenurlapp.shortenService.service.ShortenUrlService;
import jakarta.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
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
  public ResponseEntity<?> redirectShortenUrl(@PathVariable String shortenUrlKey)
      throws URISyntaxException {
    String originalUrl = shortenUrlService.getOriginalUrlByShortenUrlKey(shortenUrlKey);

    URI redirectUri = new URI(originalUrl);
    HttpHeaders httpHeaders = new HttpHeaders();
    httpHeaders.setLocation(redirectUri);

    return new ResponseEntity<>(httpHeaders, HttpStatus.MOVED_PERMANENTLY);
  }

  @GetMapping(value = "/shortenUrl/{shortenUrlKey}")
  public ResponseEntity<ShortenUrlInformationDto> getShortenUrl(@PathVariable String shortenUrlKey) {
    ShortenUrlInformationDto shortenUrlInformationDto = shortenUrlService.getShortenUrlByShortenUrlKey(shortenUrlKey);
    return ResponseEntity.ok(shortenUrlInformationDto);
  }

}
