package org.example.loanprocessingapp.LoanProcessingApp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(exclude = {org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration.class})
public class LoanProcessingAppApplication {

    public static void main(String[] args) {
        SpringApplication.run(LoanProcessingAppApplication.class, args);
    }
}