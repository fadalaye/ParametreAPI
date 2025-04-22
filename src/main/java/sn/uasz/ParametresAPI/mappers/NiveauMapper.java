package sn.uasz.ParametresAPI.mappers;

import sn.uasz.ParametresAPI.dto.NiveauDto;
import sn.uasz.ParametresAPI.entities.Niveau;

public class NiveauMapper {

    // Convertir Niveau en NiveauDto
    public static NiveauDto toDto(Niveau niveau) {
        return new NiveauDto(niveau.getId(), niveau.getNom());
    }

    // Convertir NiveauDto en Niveau
    public static Niveau toEntity(NiveauDto niveauDto) {
        return new Niveau(niveauDto.getId(), niveauDto.getNom());
    }
}
