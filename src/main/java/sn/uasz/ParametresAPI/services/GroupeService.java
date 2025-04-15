package sn.uasz.ParametresAPI.services;

import sn.uasz.ParametresAPI.dto.GroupeDTO;
import java.util.List;

public interface GroupeService {
    GroupeDTO ajouterGroupe(GroupeDTO groupeDTO);
    GroupeDTO modifierGroupe(Long id, GroupeDTO groupeDetailsDTO);
    void supprimerGroupe(Long id);
    GroupeDTO rechercherGroupeParId(Long id); // Ajout pour la complétude
    GroupeDTO rechercherGroupeParNom(String nom);
    List<GroupeDTO> listerTousLesGroupes(); // Ajout pour la complétude
}