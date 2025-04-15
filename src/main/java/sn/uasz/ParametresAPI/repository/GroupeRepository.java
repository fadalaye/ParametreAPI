package sn.uasz.ParametresAPI.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sn.uasz.ParametresAPI.entities.Groupe;

import java.util.Optional;

@Repository
public interface GroupeRepository extends JpaRepository<Groupe, Long> {

    // Recherche un groupe par son nom (en supposant que le nom est unique ou que vous voulez le premier trouvé)
    Optional<Groupe> findByNom(String nom);

    // Optional : Recherche par nom en ignorant la casse
    Optional<Groupe> findByNomIgnoreCase(String nom);

    // Vous pourriez ajouter d'autres méthodes de recherche si nécessaire, par exemple par classeId:
    // List<Groupe> findByClasseId(Long classeId);
}