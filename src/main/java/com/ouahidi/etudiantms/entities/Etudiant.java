package com.ouahidi.etudiantms.entities;
import jakarta.persistence.*;
import lombok.*;
@Entity
@Getter @Setter @ToString @AllArgsConstructor @NoArgsConstructor
@Builder

public class Etudiant {
    @Id  // @GeneratedValue(strategy = GenerationType.IDENTITY)
    public String idEtudiant;
    public String nom;
    public String prenom;
    public Integer age;

}
