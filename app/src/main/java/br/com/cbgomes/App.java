package br.com.cbgomes;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
@ComponentScan (basePackages = {"br.com.cbgomes.*"})
public class App {
    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }
}
