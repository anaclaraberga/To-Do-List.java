package br.edu.fag.todolist.docs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;

@Configuration
@EnableWebMvc
public class SwaggerConfiguration {
    
    @Bean
    public OpenAPI api() {
        return new OpenAPI()
        .info(new Info()
                        .title("To-do List")
                        .description(
                                "API Rest da To-do List")
                        .contact(new Contact()
                                .name("Ana Bergamini")
                                .email("amogin1405@gmail.com"))
                        .license(new License()
                                .name("1.0")));
    }
}
