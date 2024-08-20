package com.example.shortenurlapp.repository;

import com.example.shortenurlapp.domain.ShortenUrl;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.springframework.stereotype.Repository;

@Repository
public class MapShortenUrlRepository implements ShortenUrlRepository {

  private Map<String, ShortenUrl> shortenUrls = new ConcurrentHashMap<>();

  @Override
  public void saveShortenUrl(ShortenUrl shortenUrl) {
    shortenUrls.put(shortenUrl.getShortenUrlKey(), shortenUrl);
  }

  @Override
  public ShortenUrl findShortenUrlByShortenUrlKey(String shortenUrlKey) {
    return shortenUrls.get(shortenUrlKey);
  }

}
