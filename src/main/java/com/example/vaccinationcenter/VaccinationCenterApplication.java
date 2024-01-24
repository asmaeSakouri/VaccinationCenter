package com.example.vaccinationcenter;

import com.example.vaccinationcenter.entities.CentreVaccination;
import com.example.vaccinationcenter.entities.Citoyen;
import com.example.vaccinationcenter.repositories.CitoyenRepository;
import com.example.vaccinationcenter.service.CentreService;
import com.example.vaccinationcenter.service.CitoyenService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;
import java.util.stream.Stream;

@SpringBootApplication
public class VaccinationCenterApplication {
    public static void main(String[] args) {
        SpringApplication.run(VaccinationCenterApplication.class, args);
    }
   // @Bean
    CommandLineRunner start(CentreService centreService, CitoyenService citoyenService){
        return args -> {

            Stream.of("centre1","centre2","centre3").forEach(nom->{
                CentreVaccination centreVaccination=new CentreVaccination();
                centreVaccination.setNom(nom);
                centreVaccination.setAdresse(nom+" ain sebaa Casablanca");
                centreService.saveCentre(centreVaccination);
                Stream.of("asmae","mariam","saad").forEach(name->{
                    Citoyen citoyen=new Citoyen();
                    citoyen.setNom(name);
                    citoyen.setCentreVaccination(centreVaccination);
                    citoyenService.saveCitoyen(citoyen);
                });
        });
        };
}}
