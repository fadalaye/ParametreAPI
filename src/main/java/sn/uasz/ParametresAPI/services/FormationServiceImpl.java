package sn.uasz.ParametresAPI.services;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sn.uasz.ParametresAPI.dto.FormationDto;
import sn.uasz.ParametresAPI.entities.Formation;
import sn.uasz.ParametresAPI.exceptions.FormationNotFindException;
import sn.uasz.ParametresAPI.mappers.FormationMapperImpl;
import sn.uasz.ParametresAPI.repository.FormationRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@AllArgsConstructor
@Slf4j
public class FormationServiceImpl implements FormationService {

    private final FormationRepository formationRepository;
    private final FormationMapperImpl formationMapper;

    @Override
    public Formation saveFormation(FormationDto formationDto) throws FormationNotFindException {
        log.info("Saving new formation: {}", formationDto.getLibelle());
        Formation formation = Formation.builder()
                .libelle(formationDto.getLibelle())
                .build();
        formationRepository.save(formation);
        return formation;
    }

    @Override
    public Formation updateFormation(Long id, FormationDto formationDto) throws FormationNotFindException {
        Formation formation = formationRepository.findById(id)
                .orElseThrow(() -> new FormationNotFindException("Formation not found with id: " + id));
        log.info("Updating formation with id {} to libelle: {}", id, formationDto.getLibelle());
        formation.setLibelle(formationDto.getLibelle());
        return formationRepository.save(formation);
    }

    @Override
    public void deleteFormation(Long id) throws FormationNotFindException {
        Formation formation = formationRepository.findById(id)
                .orElseThrow(() -> new FormationNotFindException("Formation not found with id: " + id));
        log.info("Deleting formation with id: {}", id);
        formationRepository.delete(formation);
    }

    @Override
    public List<FormationDto> findAllFormation() {
        log.info("Fetching all formations from database");
        return formationRepository.findAll().stream()
                .map(formationMapper::formToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public FormationDto findFormationById(Long id) throws FormationNotFindException {
        Formation formation = formationRepository.findById(id)
                .orElseThrow(() -> new FormationNotFindException("Formation not found with id: " + id));
        log.info("Fetching formation with id: {}", id);
        return formationMapper.formToDTO(formation);
    }
}
