package sn.uasz.ParametresAPI.mappers;

import sn.uasz.ParametresAPI.dto.GroupeDTO;
import sn.uasz.ParametresAPI.entities.Groupe;

public class GroupeMapper {

    // Convertir un Groupe en GroupeDTO
    public static GroupeDTO toDTO(Groupe groupe) {
        if (groupe == null) {
            return null;
        }

        GroupeDTO dto = new GroupeDTO();
        dto.setId(groupe.getId());
        dto.setNom(groupe.getNom());
        dto.setTypeGroupe(groupe.getTypeGroupe());
        dto.setCapacite(groupe.getCapacite());
        dto.setCreatedBy(groupe.getCreatedBy());
        dto.setCreatedAt(groupe.getCreatedAt());
        return dto;
    }

    // Convertir un GroupeDTO en Groupe (sans charger la Classe complète ici)
    public static Groupe toEntity(GroupeDTO dto) {
        if (dto == null) {
            return null;
        }

        Groupe groupe = new Groupe();
        groupe.setId(dto.getId());
        groupe.setNom(dto.getNom());
        groupe.setTypeGroupe(dto.getTypeGroupe());
        groupe.setCapacite(dto.getCapacite());

        // Ici, normalement on devrait rechercher la Classe par son ID avec un service
        // Donc pour l’instant, on laisse groupe.setClasse(null) ou on le fait au niveau du service

        groupe.setCreatedBy(dto.getCreatedBy());
        groupe.setCreatedAt(dto.getCreatedAt());
        return groupe;
    }
}
