package sn.uasz.ParametresAPI.mappers;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import sn.uasz.ParametresAPI.dto.FormationDto;
import sn.uasz.ParametresAPI.entities.Formation;

@Service
public class FormationMapperImpl {
    public FormationDto formToDTO(Formation formation) {
        FormationDto formationDto = new FormationDto();
        BeanUtils.copyProperties(formation, formationDto);
        return formationDto;
    }
    public Formation DTOToForm(FormationDto formationDto) {
        Formation formation = new Formation();
        BeanUtils.copyProperties(formationDto, formation);
        return formation;
    }
}
