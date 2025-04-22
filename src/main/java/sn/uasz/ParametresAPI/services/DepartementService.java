package sn.uasz.ParametresAPI.services;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import sn.uasz.ParametresAPI.dto.DepartementDto;
import sn.uasz.ParametresAPI.entities.Departement;
import sn.uasz.ParametresAPI.exceptions.DepartementNotFindException;
import sn.uasz.ParametresAPI.mappers.DepartementMapper;
import sn.uasz.ParametresAPI.repository.DepartementRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@AllArgsConstructor
@Slf4j
public class DepartementService {
    private DepartementMapper departementMapper;
    private DepartementRepository departementRepository;

    public List<DepartementDto> getAllDepartements() {
        log.info("getAllDepartements");
        List<Departement> departements = departementRepository.findAll();
        return departements.stream().map(departement -> departementMapper
                .toDto(departement)).collect(Collectors.toList());
    }

    public DepartementDto getDepartement(Long id) throws DepartementNotFindException {
        log.info("getDepartement");
        Departement departement = departementRepository.findById(id).orElseThrow(()->
                new DepartementNotFindException("La departement " + id + " n'existe pas"));
        return departementMapper.toDto(departement);
    }

    public Departement saveDepartement(DepartementDto departementDto) {
        log.info("saveDepartement");
//        Departement departement = Departement.builder()
//                .nomDepartement(departementDto.getNomDepartement())
//                .createAt(departementDto.getCreateAt())
//                .createby(departementDto.getCreateby())
//                .build();
        Departement departement = departementMapper.toEntity(departementDto);
        return departementRepository.save(departement);
    }

    public void deleteDepartement(Long id) throws DepartementNotFindException {
        log.info("deleteDepartement");
        Departement departement = departementRepository.findById(id).orElseThrow(()->
                new DepartementNotFindException("La departement " + id + " n'existe pas"));
        departementRepository.delete(departement);
    }

    public Departement updateDepartement(DepartementDto departementDto, Long id) throws DepartementNotFindException {
        log.info("updateDepartement");
        Departement departement = departementRepository.findById(id).orElseThrow(()->
                new DepartementNotFindException("La departement " + id + " n'existe pas"));
        departement.setNomDepartement(departementDto.getNomDepartement());
        departement.setCreateby(departementDto.getCreateby());
        departement.setCreateAt(departementDto.getCreateAt());
        return departementRepository.save(departement);
    }


}
