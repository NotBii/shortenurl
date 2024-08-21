package com.example.shortenurlapp.shortenService.repository;

import com.example.shortenurlapp.shortenService.domain.ShortenUrl;

public interface ShortenUrlRepository {
  void saveShortenUrl(ShortenUrl shortenUrl);

  ShortenUrl findShortenUrlByShortenUrlKey(String shortenUrlKey);
}
