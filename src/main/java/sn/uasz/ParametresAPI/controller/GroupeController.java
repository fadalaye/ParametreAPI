package sn.uasz.ParametresAPI.controller;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sn.uasz.ParametresAPI.dto.GroupeDTO;
import sn.uasz.ParametresAPI.services.GroupeService;

import java.util.List;

@RestController
@RequestMapping("/api/groupes") // Chemin de base pour les opérations sur les groupes
// Pour l'injection du service
public class GroupeController {

    private final GroupeService groupeService;

    public GroupeController(GroupeService groupeService) {
        this.groupeService = groupeService;
    }

    // POST /api/groupes - Ajouter un nouveau groupe
    @PostMapping
    public ResponseEntity<GroupeDTO> ajouterGroupe(@RequestBody GroupeDTO groupeDTO) {
        // Ici, vous pourriez ajouter de la validation sur groupeDTO (@Valid)
        GroupeDTO nouveauGroupe = groupeService.ajouterGroupe(groupeDTO);
        // Retourne 201 Created avec le DTO du groupe créé dans le corps
        return new ResponseEntity<>(nouveauGroupe, HttpStatus.CREATED);
    }

    // PUT /api/groupes/{id} - Modifier un groupe existant
    @PutMapping("/{id}")
    public ResponseEntity<GroupeDTO> modifierGroupe(@PathVariable Long id, @RequestBody GroupeDTO groupeDTO) {
        // Validation possible ici aussi
        GroupeDTO groupeModifie = groupeService.modifierGroupe(id, groupeDTO);
        // Retourne 200 OK avec le DTO mis à jour
        return ResponseEntity.ok(groupeModifie);
    }

    // DELETE /api/groupes/{id} - Supprimer un groupe par ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> supprimerGroupe(@PathVariable Long id) {
        groupeService.supprimerGroupe(id);
        // Retourne 204 No Content (pas de corps de réponse)
        return ResponseEntity.noContent().build();
    }

    // GET /api/groupes/{id} - Rechercher un groupe par ID
    @GetMapping("/{id}")
    public ResponseEntity<GroupeDTO> rechercherGroupeParId(@PathVariable Long id) {
        GroupeDTO groupe = groupeService.rechercherGroupeParId(id);
        // Retourne 200 OK avec le DTO trouvé
        return ResponseEntity.ok(groupe);
    }

    // GET /api/groupes/recherche?nom={nom} - Rechercher un groupe par nom (via query parameter)
    @GetMapping("/recherche")
    public ResponseEntity<GroupeDTO> rechercherGroupeParNom(@RequestParam String nom) {
        GroupeDTO groupe = groupeService.rechercherGroupeParNom(nom);
        // Retourne 200 OK avec le DTO trouvé
        return ResponseEntity.ok(groupe);
    }

    // GET /api/groupes - Lister tous les groupes
    @GetMapping
    public ResponseEntity<List<GroupeDTO>> listerTousLesGroupes() {
        List<GroupeDTO> groupes = groupeService.listerTousLesGroupes();
        // Retourne 200 OK avec la liste des DTOs
        return ResponseEntity.ok(groupes);
    }

    // Vous pouvez ajouter un @ExceptionHandler ici ou utiliser un @ControllerAdvice global
    // pour gérer ResourceNotFoundException et retourner un HttpStatus.NOT_FOUND propre.
}