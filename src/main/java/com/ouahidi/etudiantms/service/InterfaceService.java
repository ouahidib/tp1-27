package com.ouahidi.etudiantms.service;

import com.ouahidi.etudiantms.DTOs.EtudiantRequestDTO;
import com.ouahidi.etudiantms.DTOs.EtudiantResponseDTO;

import java.util.List;

public interface InterfaceService {
    public EtudiantResponseDTO getEtudiantById(String id);
    public List<EtudiantResponseDTO> getAllEtudiants();
    public void  createEtudiant(EtudiantRequestDTO e);
    public void updateEtudiant(String id, EtudiantRequestDTO e);
    public void deleteEtudiant(String  id);



}
