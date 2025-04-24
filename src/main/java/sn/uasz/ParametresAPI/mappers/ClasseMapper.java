package sn.uasz.ParametresAPI.mappers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import sn.uasz.ParametresAPI.dto.ClasseDTO;
import sn.uasz.ParametresAPI.entities.Classe;
import sn.uasz.ParametresAPI.repository.CycleRepository;

@Component
public class ClasseMapper {

     @Autowired
    private NiveauRepository niveauRepository;

    @Autowired
    private FormationRepository formationRepository;

    @Autowired
    private CycleRepository cycleRepository;

    @Autowired
    private SalleRepository salleRepository;

    @Autowired
    private SemestreRepository semestreRepository;

    public Classe toEntity(ClasseDTO dto) {
        Classe classe = new Classe();
        classe.setId(dto.getId());
        classe.setNom(dto.getNom());
        classe.setNbrEtudiant(dto.getNbrEtudiant());
        classe.setCreateby(dto.getCreateby());
        classe.setCreateat(dto.getCreateat());

        classe.setNiveau(niveauRepository.findById(dto.getNiveauId()).orElse(null));
        classe.setFormation(formationRepository.findById(dto.getFormationId()).orElse(null));
        classe.setCycle(cycleRepository.findById(dto.getCycleId()).orElse(null));
        classe.setSalle(salleRepository.findById(dto.getSalleId()).orElse(null));
        classe.setSemestre(semestreRepository.findById(dto.getSemestreId()).orElse(null));

        return classe;
    }

    public ClasseDTO toDto(Classe classe) {
        ClasseDTO dto = new ClasseDTO();
        dto.setId(classe.getId());
        dto.setNom(classe.getNom());
        dto.setNbrEtudiant(classe.getNbrEtudiant());
        dto.setCreateby(classe.getCreateby());
        dto.setCreateat(classe.getCreateat());

        dto.setNiveauId(classe.getNiveau() != null ? classe.getNiveau().getId() : null);
        dto.setFormationId(classe.getFormation() != null ? classe.getFormation().getId() : null);
        dto.setCycleId(classe.getCycle() != null ? classe.getCycle().getId() : null);
        dto.setSalleId(classe.getSalle() != null ? classe.getSalle().getId() : null);
        dto.setSemestreId(classe.getSemestre() != null ? classe.getSemestre().getId() : null);

        return dto;
    } 
}
