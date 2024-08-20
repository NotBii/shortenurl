package com.example.shortenurlapp.application;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import com.example.shortenurlapp.domain.ShortenUrl;
import com.example.shortenurlapp.dto.ShortenUrlCreateRequestDto;
import com.example.shortenurlapp.exception.LackOfShortenUrlKey;
import com.example.shortenurlapp.repository.ShortenUrlRepository;
import com.example.shortenurlapp.service.ShortenUrlService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class ShortenUrlServiceUnitTest {

  @Mock
  private ShortenUrlRepository shortenUrlRepository;

  @InjectMocks
  private ShortenUrlService shortenUrlService;

  @Test
  @DisplayName("단축URL 지속 중복시 LackOfShortenurlKey 예외 발생")
  void throwLackOfShortenUrlKeyExceptionTest() {
    ShortenUrlCreateRequestDto requestDto = new ShortenUrlCreateRequestDto(null);

    when(shortenUrlRepository.findShortenUrlByShortenUrlKey(any())).thenReturn(new ShortenUrl(null, null));

    Assertions.assertThrows(LackOfShortenUrlKey.class, ()-> {shortenUrlService.createShortenUrl(requestDto);});
  }

}
