package sn.uasz.ParametresAPI.dto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Représente un Data Transfer Object (DTO) pour un département.
 *
 * Cette classe est utilisée pour transférer les données d'un département
 * entre les différentes couches de l'application.
 *
 * @author [Votre Nom]
 * @version 1.0
 */
@Data // Utilisation de Lombok pour générer les méthodes getter, setter, toString, etc.
@AllArgsConstructor // Génère un constructeur avec tous les paramètres
@NoArgsConstructor // Génère un constructeur sans paramètres
public class DepartementDto {

    /**
     * Identifiant unique du département.
     */
    private Long id;

    /**
     * Nom du département.
     */
    private String nomDepartement;

    /**
     * Utilisateur qui a créé le département.
     */
    private String createby;

    /**
     * Date de création du département.
     */
    private String createAt;
}
