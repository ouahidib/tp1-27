package com.ouahidi.etudiantms.service;

import com.ouahidi.etudiantms.DTOs.EtudiantRequestDTO;
import com.ouahidi.etudiantms.DTOs.EtudiantResponseDTO;
import com.ouahidi.etudiantms.entities.Etudiant;
import com.ouahidi.etudiantms.mapper.InterfaceMapper;

import com.ouahidi.etudiantms.repositories.EtudiantRepository;
import org.springframework.beans.BeanUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@org.springframework.stereotype.Service

public class Service implements InterfaceService {
    public Service(EtudiantRepository etudiantRepository, InterfaceMapper interfaceMapper) {
        this.etudiantRepository = etudiantRepository;
        this.interfaceMapper = interfaceMapper;
    }

    EtudiantRepository etudiantRepository;
    InterfaceMapper interfaceMapper;


    // GET By ID
    @Override
    public EtudiantResponseDTO getEtudiantById(String id) {
        Etudiant etudiant = etudiantRepository.findById(id).get();

       // Mapper  mapper = new Mapper();
        return interfaceMapper.etudiant2ResponseEtudiantDTO(etudiant);
    }

    // GET ALL
    @Override
    public List<EtudiantResponseDTO> getAllEtudiants() {
        List<Etudiant> etudiants = etudiantRepository.findAll();
        List<EtudiantResponseDTO> responseEtudiantDTOs = new ArrayList<>();
        for (Etudiant e : etudiants) {
            responseEtudiantDTOs.add(interfaceMapper.etudiant2ResponseEtudiantDTO(e));
        }
        return responseEtudiantDTOs;
    }

    // POST
    @Override
    public void createEtudiant(EtudiantRequestDTO e) {
        Etudiant x = new Etudiant();

        BeanUtils.copyProperties(e,x);
        x.setIdEtudiant(UUID.randomUUID().toString());
        etudiantRepository.save(x);

    }

    // PUT
    @Override
    public void updateEtudiant(String id, EtudiantRequestDTO e) {
        Etudiant etudiant = etudiantRepository.findById(id).
                orElseThrow(() ->
                        new RuntimeException(String.format("etudiant %s not found", id)));

        if (e.getNom() != null) {
            etudiant.setNom(e.getNom());
        }
        if (e.getAge() != null) {
            etudiant.setAge(e.getAge());}

        if (e.getPrenom() != null) {
            etudiant.setPrenom(e.getPrenom());
        }

        etudiantRepository.save(etudiant);
    }

    @Override
    public void deleteEtudiant(String id) {

        Etudiant  x = etudiantRepository.findById(id).orElseThrow(
                () -> new RuntimeException(String.format("etudiant %s not found", id))
        );
        etudiantRepository.delete(x);

    }


}


