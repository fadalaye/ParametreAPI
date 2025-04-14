package sn.uasz.ParametresAPI.services;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import sn.uasz.ParametresAPI.dto.DepartementDto;
import sn.uasz.ParametresAPI.entities.Departement;
import sn.uasz.ParametresAPI.exceptions.DepartementNotFindException;
import sn.uasz.ParametresAPI.mappers.DepartementMapper;
import sn.uasz.ParametresAPI.repository.DepartementRepository;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Service pour gérer les opérations liées aux départements.
 *
 * Cette classe fournit des méthodes pour créer, lire, mettre à jour et
 * supprimer des départements dans l'application.
 *
 * @author [Votre Nom]
 * @version 1.0
 */
@Service
@Transactional
@AllArgsConstructor
@Slf4j
public class DepartementService {

    private DepartementMapper departementMapper;
    private DepartementRepository departementRepository;

    /**
     * Récupère tous les départements.
     *
     * @return une liste de {@link DepartementDto} représentant tous les départements.
     */
    public List<DepartementDto> getAllDepartements() {
        log.info("getAllDepartements");
        List<Departement> departements = departementRepository.findAll();
        return departements.stream().map(departement -> departementMapper
                .toDepartementDto(departement)).collect(Collectors.toList());
    }

    /**
     * Récupère un département par son identifiant.
     *
     * @param id l'identifiant du département à récupérer.
     * @return un {@link DepartementDto} représentant le département.
     * @throws DepartementNotFindException si le département n'est pas trouvé.
     */
    public DepartementDto getDepartement(Long id) throws DepartementNotFindException {
        log.info("getDepartement");
        Departement departement = departementRepository.findById(id).orElseThrow(() ->
                new DepartementNotFindException("La departement " + id + " n'existe pas"));
        return departementMapper.toDepartementDto(departement);
    }

    /**
     * Enregistre un nouveau département.
     *
     * @param departementDto les données du département à enregistrer.
     * @return le département enregistré.
     */
    public Departement saveDepartement(DepartementDto departementDto) {
        log.info("saveDepartement");
        Departement departement = Departement.builder()
                .nomDepartement(departementDto.getNomDepartement())
                .createAt(departementDto.getCreateAt())
                .createby(departementDto.getCreateby())
                .build();
        return departementRepository.save(departement);
    }

    /**
     * Supprime un département par son identifiant.
     *
     * @param id l'identifiant du département à supprimer.
     * @throws DepartementNotFindException si le département n'est pas trouvé.
     */
    public void deleteDepartement(Long id) throws DepartementNotFindException {
        log.info("deleteDepartement");
        Departement departement = departementRepository.findById(id).orElseThrow(() ->
                new DepartementNotFindException("La departement " + id + " n'existe pas"));
        departementRepository.delete(departement);
    }

    /**
     * Met à jour un département existant.
     *
     * @param departementDto les nouvelles données du département.
     * @param id l'identifiant du département à mettre à jour.
     * @return le département mis à jour.
     * @throws DepartementNotFindException si le département n'est pas trouvé.
     */
    public Departement updateDepartement(DepartementDto departementDto, Long id) throws DepartementNotFindException {
        log.info("updateDepartement");
        Departement departement = departementRepository.findById(id).orElseThrow(() ->
                new DepartementNotFindException("La departement " + id + " n'existe pas"));
        departement.setNomDepartement(departementDto.getNomDepartement());
        departement.setCreateby(departementDto.getCreateby());
        departement.setCreateAt(departementDto.getCreateAt());
        return departementRepository.save(departement);
    }
}
