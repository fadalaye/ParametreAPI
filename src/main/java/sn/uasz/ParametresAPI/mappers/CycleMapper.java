package sn.uasz.ParametresAPI.mappers;


import sn.uasz.ParametresAPI.dto.CycleDto;
import sn.uasz.ParametresAPI.entities.Cycle;

public class CycleMapper {

    public static CycleDto toDto(Cycle cycle) {
        return CycleDto.builder()
                .id(cycle.getId())
                .nom(cycle.getNom())
                .build();
    }

    public static Cycle toEntity(CycleDto dto) {
        return Cycle.builder()
                .id(dto.getId())
                .nom(dto.getNom())
                .build();
    }
}
