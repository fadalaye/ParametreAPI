package sn.uasz.ParametresAPI.mappers;

import org.springframework.stereotype.Component;

import sn.uasz.ParametresAPI.dto.CycleDTO;
import sn.uasz.ParametresAPI.entities.Cycle;

@Component
public class CycleMapper {

    public CycleDTO toDto(Cycle cycle) {
        CycleDTO dto = new CycleDTO();
        dto.setId(cycle.getId());
        dto.setNom(cycle.getNom());
        return dto;
    }

    public Cycle toEntity(CycleDTO dto) {
        Cycle cycle = new Cycle();
        cycle.setId(dto.getId());
        cycle.setNom(dto.getNom());
        return cycle;
    }
}

