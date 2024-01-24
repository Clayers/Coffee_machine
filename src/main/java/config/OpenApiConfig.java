package config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.models.OpenAPI;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@OpenAPIDefinition(
        info = @Info(
                title = "Coffee Machine Api",
                description = "Coffee Machine", version = "1.0.0",
                contact = @Contact(
                        name = "Vadim V",
                        email = "KVV@gmail.com",
                        url = "http://localhost:7000"
                )
        )
)
public class OpenApiConfig {

}
