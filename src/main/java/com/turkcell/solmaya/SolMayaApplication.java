package com.turkcell.solmaya;

import jakarta.jws.WebService;
import jakarta.xml.ws.WebServiceProvider;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@WebService
@WebServiceProvider
@SpringBootApplication
public class SolMayaApplication {

    public static void main(String[] args) {
        SpringApplication.run(SolMayaApplication.class, args);
    }

   /* @Bean
    public Endpoint endpoint() {
        return Endpoint.publish("http://localhost:8084/", new CategoryService());
    }*/
}
