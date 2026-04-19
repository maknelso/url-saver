package com.nelson.urlsaver.controller;

import com.nelson.urlsaver.controller.UrlController;
import com.nelson.urlsaver.entity.Url;
import com.nelson.urlsaver.repository.UrlRepository;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import org.springframework.test.context.ActiveProfiles;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@ActiveProfiles("test")
@WebMvcTest(UrlController.class)
public class UrlControllerTest {

    // Simulates browser requests
    @Autowired
    private MockMvc mockMvc;

    // Creates a fake version of your Repo
    @MockBean
    private UrlRepository urlRepository;

    @Test
    public void testAddUrl() throws Exception {

        Url mockUrl = new Url();
        mockUrl.setId(1L);
        mockUrl.setOriginalUrl("https://google.com");

        // When the repo's save method is called, return our mockUrl
        Mockito.when(urlRepository.save(Mockito.any(Url.class))).thenReturn(mockUrl);

        mockMvc.perform(post("/api/urls")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"originalUrl\": \"https://google.com\"}"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1))
                .andExpect(jsonPath("$.originalUrl").value("https://google.com"));
    }
}