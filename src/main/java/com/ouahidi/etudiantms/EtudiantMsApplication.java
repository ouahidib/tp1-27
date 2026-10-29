package com.ouahidi.etudiantms;

import com.ouahidi.etudiantms.entities.Etudiant;
import com.ouahidi.etudiantms.repositories.EtudiantRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;
import java.util.UUID;

@SpringBootApplication
public class EtudiantMsApplication {

    public static void main(String[] args) {
        SpringApplication.run(EtudiantMsApplication.class, args);
    }

    @Bean
CommandLineRunner start(EtudiantRepository rep) {
        return args -> {

            Etudiant e1=Etudiant.builder()
                    .idEtudiant(UUID.randomUUID().toString())
                    .nom("Kaoutar")
                    .age(19)
                    .prenom("Fathi")
                    .build();
            rep.save(e1);

            Etudiant e2=Etudiant.builder()
                    .idEtudiant(UUID.randomUUID().toString())
                    .nom("Hadoumi")
                    .age(19)
                    .prenom("anas")
                    .build();
            rep.save(e2);

            Etudiant e3=Etudiant.builder()
                    .idEtudiant(UUID.randomUUID().toString())
                    .nom("Rami")
                    .age(20)
                    .prenom("aziz")
                    .build();
            rep.save(e3);

            List<Etudiant> etudiants = rep.findAll();

            for(Etudiant etudiant : etudiants) {
                System.out.println(etudiant);

            }



        };



}

}
