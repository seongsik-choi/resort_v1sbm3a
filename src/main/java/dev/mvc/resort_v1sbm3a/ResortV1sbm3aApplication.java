package dev.mvc.resort_v1sbm3a;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"dev.mvc"}) 
// Component scan : Controller, DAO, Process class등을 자동으로 인식할 패키지 선언
public class ResortV1sbm3aApplication {

    public static void main(String[] args) {
        SpringApplication.run(ResortV1sbm3aApplication.class, args);
    }

}