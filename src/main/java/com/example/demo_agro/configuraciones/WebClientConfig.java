package com.example.demo_agro.configuraciones;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

public class WebClientConfig {

    /* Define la URL base de Facebook para reutilizarla
    private final String BASE_URL = "https://graph.facebook.com";

    @Bean
    public WebClient webClient(WebClient.Builder builder) {
        // Configuramos la URL base y otras opciones (time-outs, filtros, etc.)
        return builder.baseUrl(BASE_URL)
                .build();
    }*/
}