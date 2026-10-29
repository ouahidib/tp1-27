package com.ouahidi.etudiantms.mapper;

import com.ouahidi.etudiantms.DTOs.EtudiantRequestDTO;
import com.ouahidi.etudiantms.DTOs.EtudiantResponseDTO;
import com.ouahidi.etudiantms.entities.Etudiant;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class Mapper implements InterfaceMapper {

    @Override
    public Etudiant requestEtudiantDTO2Etudiant(EtudiantRequestDTO e) {
        Etudiant x = new Etudiant();
        BeanUtils.copyProperties(e,x); // copy les attributs de e vers x
       x.setIdEtudiant(UUID.randomUUID().toString());
        // generer un id unique
        return x;
    }

    @Override
    public EtudiantResponseDTO etudiant2ResponseEtudiantDTO(Etudiant e) {

        EtudiantResponseDTO x = new EtudiantResponseDTO();
        BeanUtils.copyProperties(e,x);
        return x;

    }
}
