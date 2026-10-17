package com.ouahidi.etudiantms;

import com.ouahidi.etudiantms.entities.Etudiant;
import com.ouahidi.etudiantms.repositories.EtudiantRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class EtudiantMsApplication {

    public static void main(String[] args) {
        SpringApplication.run(EtudiantMsApplication.class, args);
    }

    @Bean
CommandLineRunner start(EtudiantRepository rep) {
        return args -> {

            Etudiant e1=Etudiant.builder()
                    .nom("Kaoutar")
                    .age(19)
                    .prenom("Fathi")
                    .build();
            rep.save(e1);

            Etudiant e2=Etudiant.builder()
                    .nom("Hadoumi")
                    .age(19)
                    .prenom("anas")
                    .build();

            rep.save(e2);




        };



}

}
