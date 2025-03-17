package com.DaniloMendes.ct_master.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class config {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("CT Master API")
                        .version("1.0")
                        .description("API para gerenciamento de aulas experimentais, agendamentos e alunos do Centro de Treinamentos de Artes Marciais")
                );
    }
}
