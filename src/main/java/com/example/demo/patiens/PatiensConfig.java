package com.example.demo.patiens;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class PatiensConfig {

    @Bean
    CommandLineRunner commandLineRunner(PatiensRepository patiensRepository){
        return args -> {
            Patiens Luisa = new Patiens(
                    "Luisa",
                    "Gomez",
                    40239209384L,
                    8099380234L,
                    "Carnal Treatment",
                    5000L,
                    LocalDate.of(1992, Month.AUGUST, 13)
            );

            Patiens Jose = new Patiens(
                    "Jose",
                    "Vazques",
                    40239479330L,
                    8490293290L,
                    "pull out tooth",
                    3500L,
                    LocalDate.of(2007, Month.AUGUST, 9)
            );

            patiensRepository.saveAll(
                    List.of(Luisa, Jose)
            );
        };
    }
}
