package kz.suneclipse.monitor_sensors.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenAPIConfig {
//    private SecurityScheme createAPIKeyScheme() {
//        return new SecurityScheme().type(SecurityScheme.Type.HTTP)
//                .bearerFormat("JWT")
//                .scheme("bearer");
//    }

    //TODO не забыть дописать ссылки
    @Bean
    public OpenAPI openAPI() {
        return new OpenAPI()
//                .addSecurityItem(new SecurityRequirement().
//                        addList("Bearer Authentication"))
//                .components(new Components().addSecuritySchemes
//                        ("Bearer Authentication", createAPIKeyScheme()))
                .info(new Info().title("AGSR Тестовое задание.")
                        .description("API тестового задания.")
                        .version("1.0").contact(new Contact().name("Маэстро")
                                .email("watashirustam@gmail.com")
                                .url("Ссылка на гитхаб")));
    }


}