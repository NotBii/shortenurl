package com.example.shortenurlapp.repository;

import com.example.shortenurlapp.domain.ShortenUrl;

public interface ShortenUrlRepository {
  void saveShortenUrl(ShortenUrl shortenUrl);
}
