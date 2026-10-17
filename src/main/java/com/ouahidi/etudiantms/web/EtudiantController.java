package com.ouahidi.etudiantms.web;

import com.ouahidi.etudiantms.entities.Etudiant;
import com.ouahidi.etudiantms.repositories.EtudiantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EtudiantController {
    EtudiantRepository etudiantRepository;
    // ICI IoC par ID par constructeur
    public EtudiantController(EtudiantRepository etudiantRepository) {
        this.etudiantRepository = etudiantRepository;
    }


    // GET DE HTTP:
    // L'appel se fera:  http://localhost:6060/etudiants
    @GetMapping("/etudiants")
    public List<Etudiant> etudiants(){
        return etudiantRepository.findAll();
    }

    // GET
    // / L'appel se fera:  http://localhost:6060/etudiants/i
    // Si on cherche l'étudiant d'Id i (un entier)
    // i passé dans les paramètres avec @PathVariable
    @GetMapping("/etudiants/{id}")
    public Etudiant etudiant(@PathVariable int id){
        return etudiantRepository.findById(id).get();
}

   // POST pour créer un étudiant sur la BD
    // l'appel sera par POST (Postman)
    // http://localhost:6060/etudiants
    // On passe etudiant dans le body de  POST
    @PostMapping("/etudiants")
    public Etudiant newEtudiant(@RequestBody Etudiant etudiant){
         return etudiantRepository.save(etudiant);
    }

    // appel http://localhost:6060/etudiants/2
    // enlève l'étudiant 2 de la base avec DELETTE de HTTP.
    @DeleteMapping ("/etudiants/{id}")
    public void deleteEtudiant(@PathVariable int id){
        etudiantRepository.deleteById(id);
        // Ici on suppose que l'étudiant id existe on verra comment
        // faire sinon
    }

    // On veut modifier l'etudiant id
    // par l'étudiant  etudiant donné dans le body PUT

    @PutMapping("/etudiants/{id}")
    public Etudiant modifieEtudiant (@PathVariable int id, @RequestBody Etudiant etudiant){
        return etudiantRepository.save(etudiant);
        // On verra comment améliorer tout ca.
    }


}
