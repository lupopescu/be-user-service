package be.user.service.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Collections;

@Configuration
//@EnableSwagger2
public class SwaggerConfig {


//    @Bean
//    public Docket api() {
//        return new Docket(DocumentationType.SWAGGER_2)
//                .select()
//                .apis(RequestHandlerSelectors.basePackage("be.user.services.controllers"))
//                .paths(PathSelectors.any())
//                .build()
//                .directModelSubstitute(java.time.LocalDate.class, java.sql.Date.class)
//                .directModelSubstitute(java.time.OffsetDateTime.class, java.util.Date.class)
//                .apiInfo(apiInfo())   ;
//    }
}