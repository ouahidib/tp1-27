package com.ouahidi.etudiantms.web;
import com.ouahidi.etudiantms.DTOs.EtudiantRequestDTO;
import com.ouahidi.etudiantms.DTOs.EtudiantResponseDTO;
import com.ouahidi.etudiantms.entities.Etudiant;
import com.ouahidi.etudiantms.repositories.EtudiantRepository;

import com.ouahidi.etudiantms.service.InterfaceService;
import org.springframework.web.bind.annotation.*;

import java.util.List;


// Le controlleur REST
@RestController

@RequestMapping("/api")
// Pour utiliser le controlleur par defaut
public class EtudiantController {
    public EtudiantController(InterfaceService interfaceService) {
        this.interfaceService = interfaceService;
    }

    InterfaceService interfaceService;


    // GET DE HTTP:
    // L'appel se fera:  http://localhost:6060/etudiants
    @GetMapping("/etudiants")
    public List<EtudiantResponseDTO> etudiants() {

        return interfaceService.getAllEtudiants();
    }

    // GET
    // / L'appel se fera:  http://localhost:6060/etudiants/i
    // Si on cherche l'étudiant d'Id i (un entier)
    // i passé dans les paramètres avec @PathVariable
    @GetMapping("/etudiants/{id}")
    public EtudiantResponseDTO unEtudiant(@PathVariable String id) {
        try {
            return interfaceService.getEtudiantById(id);

        } catch (RuntimeException ex) {
            throw new RuntimeException(String.format("etudiant %s not found", id));
        }


    }

    // POST pour créer un étudiant sur la BD
    // l'appel sera par POST (Postman)
    // http://localhost:6060/etudiants
    // On passe etudiant dans le body de  POST
    @PostMapping("/etudiants")
    public void newEtudiant(@RequestBody EtudiantRequestDTO etudiant) {
        interfaceService.createEtudiant(etudiant);
    }

    // appel http://localhost:6060/etudiants/2
    // enlève l'étudiant 2 de la base avec DELETTE de HTTP.
    @DeleteMapping("/etudiants/{id}")
    public void deleteEtudiant(@PathVariable String id) {
        try {
            interfaceService.deleteEtudiant(id);
        } catch (RuntimeException ex) {

        }

    }
    // On veut modifier l'etudiant id
    // par l'étudiant  etudiant donné dans le body PUT

    @PutMapping("/etudiants/{id}")
    public void modifieEtudiant(@PathVariable String  id, @RequestBody EtudiantRequestDTO etudiant) {
    try{
        interfaceService.updateEtudiant(id, etudiant);


    } catch (RuntimeException ex) {
    throw new RuntimeException(String.format("etudiant %s not found", id));
    }
    }
}