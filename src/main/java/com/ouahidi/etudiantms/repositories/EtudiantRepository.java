package com.ouahidi.etudiantms.repositories;

import com.ouahidi.etudiantms.entities.Etudiant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EtudiantRepository extends JpaRepository<Etudiant, Integer> {
}
