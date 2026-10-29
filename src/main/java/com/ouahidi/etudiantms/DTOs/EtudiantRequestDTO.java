package com.ouahidi.etudiantms.DTOs;

import lombok.*;

@Getter @Setter @ToString @AllArgsConstructor
@NoArgsConstructor @Builder

public class EtudiantRequestDTO {
    public String nom;
    public String prenom;
    public Integer age;
}
