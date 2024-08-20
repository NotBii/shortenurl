package com.example.shortenurlapp.service;

import com.example.shortenurlapp.domain.ShortenUrl;
import com.example.shortenurlapp.dto.ShortenUrlCreateRequestDto;
import com.example.shortenurlapp.dto.ShortenUrlCreateResponseDto;
import com.example.shortenurlapp.dto.ShortenUrlInformationDto;
import com.example.shortenurlapp.exception.LackOfShortenUrlKey;
import com.example.shortenurlapp.exception.NotFoundShortenUrl;
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
    String shortenUrlKey = getUniqueShortenUrlKey();



    ShortenUrl shortenUrl = new ShortenUrl(originalUrl, shortenUrlKey);
    shortenUrlRepository.saveShortenUrl(shortenUrl);

    return new ShortenUrlCreateResponseDto(shortenUrl);
  }

  public ShortenUrlInformationDto getShortenUrlByShortenUrlKey(String shortenUrlKey) {
    ShortenUrl shortenUrl = shortenUrlRepository.findShortenUrlByShortenUrlKey(shortenUrlKey);

    if(null == shortenUrl) throw new NotFoundShortenUrl();

    return new ShortenUrlInformationDto(shortenUrl);
  }

  public String getOriginalUrlByShortenUrlKey(String ShortenUrlKey) {
    ShortenUrl shortenUrl = shortenUrlRepository.findShortenUrlByShortenUrlKey(ShortenUrlKey);

    if(null == shortenUrl) throw new NotFoundShortenUrl();

    shortenUrl.increaseRedirectCount();
    shortenUrlRepository.saveShortenUrl(shortenUrl);

    return shortenUrl.getOriginalUrl();
  }

  private String generateShortenUrlKey() {
    String base56Characters = "23456789ABCDEFGHJKLMNPQRSTUVWXYZabcdefghjklmnpqrstuvwxyz";
    Random random = new Random();
    StringBuilder shortenUrlKey = new StringBuilder();

    for(int i = 0; i < 8; i++) {
      int base56CharactersIndex = random.nextInt(0, base56Characters.length());
      char base56Character = base56Characters.charAt(base56CharactersIndex);
      shortenUrlKey.append(base56Character);
    }

    return shortenUrlKey.toString();
  }

  private String getUniqueShortenUrlKey() {
    String shortenUrlKey = "";
    final int MAX_RETRY_COUNT = 5;
    int count = 0;

    while(count++ < MAX_RETRY_COUNT) {
      shortenUrlKey = generateShortenUrlKey();
      ShortenUrl shortenUrl = shortenUrlRepository.findShortenUrlByShortenUrlKey(shortenUrlKey);

      if(null == shortenUrl) return shortenUrlKey;
    }

      throw new LackOfShortenUrlKey();
  }
}
