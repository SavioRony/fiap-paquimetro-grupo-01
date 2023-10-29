package br.com.fiap.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI customOpenAPI(){
        return new OpenAPI()
                .info(new Info()
                        .title("REST API Paquimetro")
                        .version("v1")
                        .description("API de paquimetro.")
                        .termsOfService("https://github.com/SavioRony/fiap-paquimetro-grupo-01.git")
                        .license(new License().url("https://github.com/SavioRony/fiap-paquimetro-grupo-01.git")));
    }
}