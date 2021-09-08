package com.dio.live.swagger;

import org.springframework.context.annotation.Bean;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

import java.util.Collections;

public class SwaggerrConfig {
    @Bean
    public Docket apiAdmin() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.dio.live"))
                .build()
                .apiInfo(apiInfo())
                .globalOperationParameters(
                        Collections.singletonList(
                                new ParameterBuilder()
                                .name("Authorization")
                                .description("Header para Token JWT")
                                .modelRef(new ModelRef("string"))
                                .parameterType("header")
                                .required(false)
                                .build()
                        )
                );
    }
    @Bean
    public ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("API-REST")
                .description("Projeto Spring Boot Dio")
                .version("1.0.0")
                .license("Apache License Version 2.0")
                .contact(new Contact("DIO", "https://web.digitalinovation.one", "contato@digitalinovationone.com.br"))
                .build();
    }
}
