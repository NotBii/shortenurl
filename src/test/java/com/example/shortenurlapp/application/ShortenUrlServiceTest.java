package com.example.shortenurlapp.application;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.example.shortenurlapp.dto.ShortenUrlCreateRequestDto;
import com.example.shortenurlapp.dto.ShortenUrlCreateResponseDto;
import com.example.shortenurlapp.service.ShortenUrlService;
import javax.validation.constraints.AssertTrue;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ShortenUrlServiceTest {

  @Autowired
  private ShortenUrlService shortenUrlService;

  @Test
  @DisplayName("url 생성 및 조회")
  void shortenUrlAddTest() {
    String originalUrl = "https://www.google.com/";
    ShortenUrlCreateRequestDto shortenUrlCreateRequestDto = new ShortenUrlCreateRequestDto(originalUrl);

    ShortenUrlCreateResponseDto shortenUrlCreateResponseDto = shortenUrlService.createShortenUrl(shortenUrlCreateRequestDto);
    String shortenUrlKey = shortenUrlCreateResponseDto.getShortenUrlKey();

    String getResult = shortenUrlService.getOriginalUrlByShortenUrlKey(shortenUrlKey);
    assertEquals(getResult, originalUrl);

  }

}
