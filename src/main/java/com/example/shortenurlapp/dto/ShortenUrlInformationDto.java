package com.example.shortenurlapp.dto;

import lombok.Getter;

@Getter
public class ShortenUrlInformationDto {
  private String originalUrl;
  private String shortenUrlkey;
  private Long redirectCount;
}
