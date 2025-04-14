package sn.uasz.ParametresAPI.services;

import sn.uasz.ParametresAPI.dto.FormationDto;
import sn.uasz.ParametresAPI.entities.Formation;
import sn.uasz.ParametresAPI.exceptions.FormationNotFindException;

import java.util.List;

public interface FormationService {
    Formation saveFormation(FormationDto formationDto) throws FormationNotFindException;
    Formation updateFormation(Long id,FormationDto formationDto) throws FormationNotFindException;
    void deleteFormation(Long id) throws FormationNotFindException;
    List<FormationDto> findAllFormation();
    FormationDto findFormationById(Long id) throws FormationNotFindException;
}
