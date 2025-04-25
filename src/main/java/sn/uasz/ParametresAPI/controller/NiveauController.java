package sn.uasz.ParametresAPI.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import sn.uasz.ParametresAPI.dto.NiveauDto;
import sn.uasz.ParametresAPI.services.NiveauService;

import java.util.List;

@RestController
@RequestMapping("/api/niveaux")
@RequiredArgsConstructor
@Validated
public class NiveauController {

    private final NiveauService niveauService;

    // ✅ Ajouter un niveau
    @PostMapping
    public ResponseEntity<NiveauDto> createNiveau(@RequestBody @Validated NiveauDto dto) {
        NiveauDto created = niveauService.save(dto);
        return new ResponseEntity<>(created, HttpStatus.CREATED);
    }

    // ✅ Récupérer tous les niveaux
    @GetMapping
    public ResponseEntity<List<NiveauDto>> getAllNiveaux() {
        return ResponseEntity.ok(niveauService.getAll());
    }

    // ✅ Récupérer un niveau par ID
    @GetMapping("/{id}")
    public ResponseEntity<NiveauDto> getNiveauById(@PathVariable Long id) {
        return ResponseEntity.ok(niveauService.getById(id));
    }

    // ✅ Modifier un niveau
    @PutMapping("/{id}")
    public ResponseEntity<NiveauDto> updateNiveau(@PathVariable Long id, @RequestBody @Validated NiveauDto dto) {
        return ResponseEntity.ok(niveauService.update(id, dto));
    }

    // ✅ Supprimer un niveau
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteNiveau(@PathVariable Long id) {
        niveauService.delete(id);
        return ResponseEntity.noContent().build();
    }

    // ✅ Rechercher un niveau par nom (optionnel)
    @GetMapping("/search")
    public ResponseEntity<List<NiveauDto>> searchByNom(@RequestParam String nom) {
        return ResponseEntity.ok(niveauService.searchByNom(nom));
    }
}
