package sn.uasz.ParametresAPI.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sn.uasz.ParametresAPI.dto.DepartementDto;
import sn.uasz.ParametresAPI.entities.Departement;
import sn.uasz.ParametresAPI.exceptions.DepartementNotFindException;
import sn.uasz.ParametresAPI.mappers.DepartementMapper;
import sn.uasz.ParametresAPI.services.DepartementService;

import java.util.List;
import java.util.Objects;

/**
 * Contrôleur REST pour gérer les opérations liées aux départements.
 *
 * Cette classe fournit des endpoints pour créer, lire, mettre à jour et
 * supprimer des départements dans l'application.
 *
 * @author [Votre Nom]
 * @version 1.0
 */
@AllArgsConstructor
@RestController
@RequestMapping("/api/departement")
public class DepartementController {
    private DepartementService departementService;
    private DepartementMapper departementMapper;

    /**
     * Récupère la liste de tous les départements.
     *
     * @return une réponse contenant une liste de {@link DepartementDto} représentant tous les départements.
     */
    @GetMapping
    public ResponseEntity<List<DepartementDto>> getDepartements() {
        return new ResponseEntity<>(departementService.getAllDepartements(), HttpStatus.OK);
    }

    /**
     * Récupère un département par son identifiant.
     *
     * @param id l'identifiant du département à récupérer.
     * @return une réponse contenant un {@link DepartementDto} représentant le département, ou un statut NOT_FOUND si non trouvé.
     * @throws DepartementNotFindException si le département n'est pas trouvé.
     */
    @GetMapping("/{id}")
    public ResponseEntity<DepartementDto> findDepartementById(@PathVariable Long id) throws DepartementNotFindException {
        DepartementDto departementDto = departementService.getDepartement(id);
        return Objects.nonNull(departementDto) ? new ResponseEntity<>(departementDto, HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    /**
     * Enregistre un nouveau département.
     *
     * @param departementDto les données du département à enregistrer.
     * @return une réponse contenant le département enregistré avec un statut CREATED.
     * @throws DepartementNotFindException si une erreur se produit lors de l'enregistrement.
     */
    @PostMapping
    public ResponseEntity<Departement> saveDepartement(@RequestBody DepartementDto departementDto) throws DepartementNotFindException {
        Departement departement = departementService.saveDepartement(departementDto);
        return new ResponseEntity<>(departement, HttpStatus.CREATED);
    }

    /**
     * Met à jour un département existant.
     *
     * @param departementDto les nouvelles données du département.
     * @param id l'identifiant du département à mettre à jour.
     * @return une réponse contenant le département mis à jour, ou un statut NOT_FOUND si le département n'existe pas.
     * @throws DepartementNotFindException si le département n'est pas trouvé.
     */
    @PutMapping("/{id}")
    public ResponseEntity<Departement> updateDepartement(@RequestBody DepartementDto departementDto,
                                                         @PathVariable Long id) throws DepartementNotFindException {
        DepartementDto departementExistant = departementService.getDepartement(id);
        if (departementExistant != null) {
            departementExistant.setNomDepartement(departementDto.getNomDepartement());
            departementExistant.setCreateby(departementDto.getCreateby());
            departementExistant.setCreateAt(departementDto.getCreateAt());
            Departement departement = departementService.updateDepartement(departementExistant, id);
            return new ResponseEntity<>(departement, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    /**
     * Supprime un département par son identifiant.
     *
     * @param id l'identifiant du département à supprimer.
     * @return une réponse avec un statut OK si la suppression a réussi, ou NOT_FOUND si le département n'existe pas.
     * @throws DepartementNotFindException si le département n'est pas trouvé.
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDepartement(@PathVariable Long id) throws DepartementNotFindException {
        DepartementDto departementDto = departementService.getDepartement(id);
        if (departementDto != null) {
            departementService.deleteDepartement(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}