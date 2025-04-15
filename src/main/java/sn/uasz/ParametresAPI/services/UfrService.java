package sn.uasz.ParametresAPI.services;

import sn.uasz.ParametresAPI.dto.UfrDto;

import java.util.List;

public interface UfrService {
    UfrDto create(UfrDto ufrDto);
    UfrDto update(Long id, UfrDto ufrDto);
    void delete(Long id);
    UfrDto getById(Long id);
    List<UfrDto> searchByNom(String nom);
    List<UfrDto> getAll();
}

