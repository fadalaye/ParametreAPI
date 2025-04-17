package sn.uasz.ParametresAPI.mappers;

import sn.uasz.ParametresAPI.dto.NiveauDto;
import sn.uasz.ParametresAPI.entities.Niveau;

public class NiveauMapper {
    public static NiveauDto toDto(Niveau niveau) {
        NiveauDto dto = new NiveauDto();
        dto.setId(niveau.getId());
        dto.setNom(niveau.getNom());
        return dto;
    }

    public static Niveau toEntity(NiveauDto dto) {
        Niveau niveau = new Niveau();
        niveau.setId(dto.getId());
        niveau.setNom(dto.getNom());
        return niveau;
    }
}
