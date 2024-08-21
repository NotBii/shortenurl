package com.example.shortenurlapp.shortenService.dto;

import com.example.shortenurlapp.shortenService.domain.ShortenUrl;
import lombok.Getter;

@Getter
public class ShortenUrlCreateResponseDto {
  private String originalUrl;
  private String shortenUrlKey;

  public ShortenUrlCreateResponseDto(ShortenUrl shortenUrl) {
    this.originalUrl = shortenUrl.getOriginalUrl();
    this.shortenUrlKey = shortenUrl.getShortenUrlKey();
  }


}
