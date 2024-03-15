package com.appalianzaapi.documentation;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class InfoDoc {

    @Bean
    public OpenAPI customOpenApi() {
        return new OpenAPI()
                .info(new Info()
                        .title("GML-Alianza")
                        .version("0.1")
                        .description("Prueba tecnica para GML-Alianza")
                )
                ;
    }

}
