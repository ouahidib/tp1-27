package com.ouahidi.etudiantms.entities;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

@Entity
@Getter @Setter @ToString @AllArgsConstructor @NoArgsConstructor
@Builder

public class Etudiant {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer idEtudiant;
    public String nom;
    public String prenom;
    public Integer age;

}
