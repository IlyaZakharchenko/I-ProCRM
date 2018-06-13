package ru.kpfu.itis.app.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import javax.servlet.MultipartConfigElement;

@SpringBootApplication
@ComponentScan(basePackages = "ru.kpfu.itis.app")
@EnableJpaRepositories(basePackages = "ru.kpfu.itis.app.repo")
@EntityScan(basePackages = "ru.kpfu.itis.app.model.entities")
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    MultipartConfigElement multipartConfigElement() {
        MultipartConfigFactory factory = new MultipartConfigFactory();
        factory.setMaxFileSize("200MB");
        factory.setMaxRequestSize("200MB");
        return factory.createMultipartConfig();
    }
}
