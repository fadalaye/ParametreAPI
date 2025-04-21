package sn.uasz.ParametresAPI.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sn.uasz.ParametresAPI.entities.Departement;

/**
 * Interface pour les opérations de persistance liées aux départements.
 *
 * Cette interface étend JpaRepository pour fournir des méthodes de
 * gestion des données pour l'entité {@link Departement}.
 *
 * @author [Votre Nom]
 * @version 1.0
 */
public interface DepartementRepository extends JpaRepository<Departement, Long> {

    /**
     * Trouve un département par son nom, sans tenir compte de la casse.
     *
     * @param nom le nom du département à rechercher.
     * @return le département correspondant, ou null si aucun département n'est trouvé.
     */
    Departement findByNomDepartementIgnoreCase(String nom);
}