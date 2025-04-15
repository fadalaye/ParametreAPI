package sn.uasz.ParametresAPI.services;

import lombok.AllArgsConstructor; // Ou utiliser @Autowired sur le constructeur
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sn.uasz.ParametresAPI.dto.GroupeDTO;
import sn.uasz.ParametresAPI.entities.Groupe;
// import sn.uasz.ParametresAPI.entities.Classe; // Décommentez si Classe est gérée
import sn.uasz.ParametresAPI.exceptions.ResourceNotFoundException;
import sn.uasz.ParametresAPI.mappers.GroupeMapper;
import sn.uasz.ParametresAPI.repository.GroupeRepository;
// import sn.uasz.ParametresAPI.repository.ClasseRepository; // Décommentez si Classe est gérée

import java.util.List;
import java.util.stream.Collectors;
import java.time.LocalDateTime; // Préférable pour les dates
import java.time.format.DateTimeFormatter; // Si vous restez avec String pour les dates

@Service
@Transactional // Bonne pratique pour les services qui modifient des données
@AllArgsConstructor // Lombok pour l'injection de dépendances via constructeur (préférable)
public class GroupeServiceImpl implements GroupeService {

    private final GroupeRepository groupeRepository;

    public GroupeServiceImpl(GroupeRepository groupeRepository) {
        this.groupeRepository = groupeRepository;
    }
    // private final ClasseRepository classeRepository; // Décommentez si Classe est gérée

    // Si vous n'utilisez pas Lombok @AllArgsConstructor:
    // @Autowired
    // public GroupeServiceImpl(GroupeRepository groupeRepository /*, ClasseRepository classeRepository */) {
    //     this.groupeRepository = groupeRepository;
    //     // this.classeRepository = classeRepository;
    // }

    @Override
    public GroupeDTO ajouterGroupe(GroupeDTO groupeDTO) {
        Groupe groupe = GroupeMapper.toEntity(groupeDTO);

        // --- Logique pour lier la Classe (ESSENTIEL) ---
        // Assurez-vous que GroupeDTO contient un champ comme 'classeId'
        // Long classeId = groupeDTO.getClasseId();
        // if (classeId == null) {
        //     throw new IllegalArgumentException("L'ID de la classe parente est requis pour créer un groupe.");
        // }
        // Classe classe = classeRepository.findById(classeId)
        //         .orElseThrow(() -> new ResourceNotFoundException("Classe non trouvée avec ID: " + classeId));
        // groupe.setClasse(classe);
        // --- Fin Logique Classe ---

        // Gérer la date/heure de création (exemple si vous utilisez String)
        // Vous devriez idéalement utiliser LocalDateTime et laisser la DB ou JPA gérer ça
        // if (groupe.getCreatedAt() == null || groupe.getCreatedAt().isEmpty()) {
        //    groupe.setCreatedAt(LocalDateTime.now().format(DateTimeFormatter.ISO_DATE_TIME));
        // }
        // Gérer createdBy (devrait venir de l'utilisateur authentifié)
        // if (groupe.getCreatedBy() == null || groupe.getCreatedBy().isEmpty()) {
        //     groupe.setCreatedBy("SYSTEM"); // Ou utilisateur actuel
        // }


        // Important : Assurez-vous que l'ID est null pour forcer une insertion
        groupe.setId(null);
        Groupe groupeSauvegarde = groupeRepository.save(groupe);
        return GroupeMapper.toDTO(groupeSauvegarde);
    }

    @Override
    public GroupeDTO modifierGroupe(Long id, GroupeDTO groupeDetailsDTO) {
        Groupe groupeExistant = groupeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Groupe non trouvé avec l'ID: " + id));

        // Mettre à jour les champs modifiables
        groupeExistant.setNom(groupeDetailsDTO.getNom());
        groupeExistant.setTypeGroupe(groupeDetailsDTO.getTypeGroupe());
        groupeExistant.setCapacite(groupeDetailsDTO.getCapacite());

        // --- Logique pour modifier la Classe si nécessaire (plus complexe) ---
        // Si GroupeDTO contient classeId et qu'il est différent de l'actuel :
        // Long nouvelleClasseId = groupeDetailsDTO.getClasseId();
        // if (nouvelleClasseId != null && !nouvelleClasseId.equals(groupeExistant.getClasse().getId())) {
        //     Classe nouvelleClasse = classeRepository.findById(nouvelleClasseId)
        //         .orElseThrow(() -> new ResourceNotFoundException("Nouvelle classe non trouvée avec ID: " + nouvelleClasseId));
        //     groupeExistant.setClasse(nouvelleClasse);
        // }
        // --- Fin Logique Classe ---

        // Ne pas écraser createdBy/createdAt lors de la modification
        // Mettre à jour updatedBy/updatedAt si ces champs existent

        Groupe groupeModifie = groupeRepository.save(groupeExistant);
        return GroupeMapper.toDTO(groupeModifie);
    }

    @Override
    public void supprimerGroupe(Long id) {
        if (!groupeRepository.existsById(id)) {
            throw new ResourceNotFoundException("Groupe non trouvé avec l'ID: " + id);
        }
        groupeRepository.deleteById(id);
    }

    @Override
    @Transactional(readOnly = true) // Optimisation pour les opérations de lecture
    public GroupeDTO rechercherGroupeParId(Long id) {
        Groupe groupe = groupeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Groupe non trouvé avec l'ID: " + id));
        return GroupeMapper.toDTO(groupe);
    }

    @Override
    @Transactional(readOnly = true)
    public GroupeDTO rechercherGroupeParNom(String nom) {
        Groupe groupe = groupeRepository.findByNomIgnoreCase(nom) // Utiliser IgnoreCase pour plus de flexibilité
                .orElseThrow(() -> new ResourceNotFoundException("Groupe non trouvé avec le nom: " + nom));
        return GroupeMapper.toDTO(groupe);
    }

    @Override
    @Transactional(readOnly = true)
    public List<GroupeDTO> listerTousLesGroupes() {
        List<Groupe> groupes = groupeRepository.findAll();
        return groupes.stream()
                .map(GroupeMapper::toDTO)
                .collect(Collectors.toList());
    }
}