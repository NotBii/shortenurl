package com.example.shortenurlapp.shortenService.dto;

import com.example.shortenurlapp.shortenService.domain.ShortenUrl;
import lombok.Getter;

@Getter
public class ShortenUrlInformationDto {
  private String originalUrl;
  private String shortenUrlkey;
  private Long redirectCount;

  public ShortenUrlInformationDto(ShortenUrl shortenUrl) {
    this.originalUrl = shortenUrl.getOriginalUrl();
    this.shortenUrlkey = shortenUrl.getShortenUrlKey();
    this.redirectCount = shortenUrl.getRedirectCount();
  }
}
