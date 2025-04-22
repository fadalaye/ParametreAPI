package sn.uasz.ParametresAPI.mappers;

import lombok.Builder;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import sn.uasz.ParametresAPI.dto.DepartementDto;
import sn.uasz.ParametresAPI.entities.Departement;
import org.springframework.stereotype.Component;

@Component // Plus approprié qu'@Service pour un mapper
public class DepartementMapper {

    public DepartementDto toDto(Departement entity) {
        if (entity == null) return null;

        return DepartementDto.builder()
                .id(entity.getId())
                .nomDepartement(entity.getNomDepartement())
                .createby(entity.getCreateby()) // Notez la casse cohérente
                .createAt(entity.getCreateAt())
                .build();
    }

    public Departement toEntity(DepartementDto dto) {
        if (dto == null) return null;

        return Departement.builder()
                .id(dto.getId())
                .nomDepartement(dto.getNomDepartement())
                .createby(dto.getCreateby()) // Adaptation de la casse
                .createAt(dto.getCreateAt())
                .build();
    }
}
