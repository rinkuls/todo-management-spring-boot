package com.todo.springboot.todomanagementspringboot.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import javax.servlet.ServletContext;
import javax.xml.datatype.XMLGregorianCalendar;

@Configuration
@EnableSwagger2
@EnableWebMvc
@Component

public class SwaggerConfiguration {

    @Bean
    @ConfigurationProperties(prefix = "test.flyway")
    public Docket newApi(ServletContext servletContext) {
        return new Docket(DocumentationType.SWAGGER_2).directModelSubstitute(XMLGregorianCalendar.class, String.class)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.todo"))
                .paths(PathSelectors.any())
                .build();
    }

    @Bean
    ApiInfo apiInfo() {
        Contact contact = new Contact("Rinkul Sharma", "https://www.linkedin.com/in/rinkul-sharma-74690773/", "rinkul.sharma123@gmail.com");

        return new ApiInfoBuilder()
                .title("Online TODO List ")
                .description("Its an Spring boot application where user can create his/her todo list list, add more item, remove or update it. ")
                .contact(contact).version("1.0.0").build();
    }


}
