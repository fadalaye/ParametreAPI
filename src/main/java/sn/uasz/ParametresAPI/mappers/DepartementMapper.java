package sn.uasz.ParametresAPI.mappers;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import sn.uasz.ParametresAPI.dto.DepartementDto;
import sn.uasz.ParametresAPI.entities.Departement;

/**
 * Mapper pour convertir entre les entités Departement et DepartementDto.
 *
 * Cette classe fournit des méthodes pour transformer les objets
 * entre les couches de l'application.
 *
 * @author [Votre Nom]
 * @version 1.0
 */
@Service
public class DepartementMapper {

    /**
     * Convertit une entité Departement en un DTO DepartementDto.
     *
     * @param departement l'entité à convertir.
     * @return un {@link DepartementDto} représentant le département.
     */
    public DepartementDto toDepartementDto(Departement departement) {
        DepartementDto departementDto = new DepartementDto();
        BeanUtils.copyProperties(departement, departementDto);
        return departementDto;
    }

    /**
     * Convertit un DTO DepartementDto en une entité Departement.
     *
     * @param departementDto le DTO à convertir.
     * @return une {@link Departement} représentant le département.
     */
    public Departement toDepartement(DepartementDto departementDto) {
        Departement departement = new Departement();
        BeanUtils.copyProperties(departementDto, departement);
        return departement;
    }
}