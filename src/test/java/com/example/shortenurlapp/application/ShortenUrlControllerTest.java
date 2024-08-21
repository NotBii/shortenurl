package com.example.shortenurlapp.application;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import com.example.shortenurlapp.shortenService.controller.ShortenUrlController;
import com.example.shortenurlapp.shortenService.service.ShortenUrlService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest(controllers = ShortenUrlController.class)
public class ShortenUrlControllerTest {

  @MockBean
  private ShortenUrlService shortenUrlService;

  @Autowired
  private MockMvc mockMvc;

  @Test
  @DisplayName("url 리다이렉트")
  void redirectTest() throws Exception {
    String expectedOriginalUrl = "https://google.com/";

    when(shortenUrlService.getOriginalUrlByShortenUrlKey(any())).thenReturn(expectedOriginalUrl);

    mockMvc.perform(get("/any-key"))
        .andExpect(status().isMovedPermanently())
        .andExpect((header().string("Location", expectedOriginalUrl)));
  }


}
