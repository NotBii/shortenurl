package com.example.shortenurlapp.service;

import com.example.shortenurlapp.domain.ShortenUrl;
import com.example.shortenurlapp.dto.ShortenUrlCreateRequestDto;
import com.example.shortenurlapp.dto.ShortenUrlCreateResponseDto;
import com.example.shortenurlapp.repository.ShortenUrlRepository;
import java.util.Random;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ShortenUrlService {

  private final ShortenUrlRepository shortenUrlRepository;

  public ShortenUrlCreateResponseDto createShortenUrl(ShortenUrlCreateRequestDto request) {
    String originalUrl = request.getOriginalUrl();
    String shortenUrlKey = generateShortenUrlKey();

    ShortenUrl shortenUrl = new ShortenUrl(originalUrl, shortenUrlKey);
    shortenUrlRepository.saveShortenUrl(shortenUrl);

    return new ShortenUrlCreateResponseDto(shortenUrl);
  }

  public static String generateShortenUrlKey() {
    String base56Characters = "23456789ABCDEFGHJKLMNPQRSTUVWXYZabcdefghjklmnpqrstuvwxyz";
    Random random = new Random();
    StringBuilder shortenUrlKey = new StringBuilder();

    for(int count = 0; count < 8; count++) {
      int base56CharactersIndex = random.nextInt(0, base56Characters.length());
      char base56Character = base56Characters.charAt(base56CharactersIndex);
      shortenUrlKey.append(base56Character);
    }

    return shortenUrlKey.toString();
  }

}
