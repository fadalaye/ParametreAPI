package sn.uasz.ParametresAPI.mappers;

import org.springframework.stereotype.Component;
import sn.uasz.ParametresAPI.dto.UfrDto;
import sn.uasz.ParametresAPI.entities.Ufr;

@Component
public class UfrMapper {

    public UfrDto toDto(Ufr ufr) {
        UfrDto dto = new UfrDto();
        dto.setId(ufr.getId());
        dto.setNom(ufr.getNom());
        dto.setCreateby(ufr.getCreateby());
        dto.setCreateat(ufr.getCreateat());
        return dto;
    }

    public Ufr toEntity(UfrDto dto) {
        Ufr ufr = new Ufr();
        ufr.setId(dto.getId());
        ufr.setNom(dto.getNom());
        ufr.setCreateby(dto.getCreateby());
        ufr.setCreateat(dto.getCreateat());
        return ufr;
    }
}

