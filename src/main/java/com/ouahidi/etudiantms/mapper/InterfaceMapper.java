package com.ouahidi.etudiantms.mapper;

import com.ouahidi.etudiantms.DTOs.EtudiantRequestDTO;
import com.ouahidi.etudiantms.DTOs.EtudiantResponseDTO;
import com.ouahidi.etudiantms.entities.Etudiant;
import org.springframework.stereotype.Component;


public interface InterfaceMapper {
    public Etudiant  requestEtudiantDTO2Etudiant(EtudiantRequestDTO e);
    public EtudiantResponseDTO etudiant2ResponseEtudiantDTO(Etudiant  e);


}
