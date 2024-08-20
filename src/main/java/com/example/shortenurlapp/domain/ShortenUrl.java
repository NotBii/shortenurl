package com.example.shortenurlapp.domain;

import java.util.Random;
import lombok.Getter;

@Getter
public class ShortenUrl {
  private String originalUrl;
  private String shortenUrlKey;
  private Long redirectCount;


  public ShortenUrl(String originalUrl, String shortenUrlKey) {
    this.originalUrl = originalUrl;
    this.shortenUrlKey = shortenUrlKey;
    this.redirectCount = 0L;
  }

}
