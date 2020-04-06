package org.springframework.boot.helloworld.controller;


@SpringBootApplication
@EnableCaching
@MapperScan("org.springframework.boot.helloworld")
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
