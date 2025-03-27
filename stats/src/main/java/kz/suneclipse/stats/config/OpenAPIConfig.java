package kz.suneclipse.stats.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenAPIConfig {

    @Bean
    public OpenAPI openAPI() {
        return new OpenAPI()
                .info(new Info().title("AGSR Тестовое задание. Другой сервис")
                        .description("API тестового задания.")
                        .version("1.0").contact(new Contact().name("Маэстро")
                                .email("watashirustam@gmail.com")
                                .url("https://github.com/RustamBaimukanov")));
    }


}