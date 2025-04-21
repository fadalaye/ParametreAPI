package sn.uasz.ParametresAPI.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sn.uasz.ParametresAPI.dto.DepartementDto;
import sn.uasz.ParametresAPI.entities.Departement;
import sn.uasz.ParametresAPI.exceptions.DepartementNotFindException;
import sn.uasz.ParametresAPI.mappers.DepartementMapper;
import sn.uasz.ParametresAPI.services.DepartementService;

import java.util.List;
import java.util.Objects;

@AllArgsConstructor
@RestController
@RequestMapping("/api/departement")
public class DepartementController {
    private DepartementService departementService;
    private DepartementMapper departementMapper;


    @GetMapping
    public ResponseEntity<List<DepartementDto>> getDepartements() {
        return new  ResponseEntity<>(departementService.getAllDepartements(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DepartementDto> findDepartementById(@PathVariable Long id) throws DepartementNotFindException {
        DepartementDto departementDto = departementService.getDepartement(id);
        return Objects.nonNull(departementDto) ? new ResponseEntity<>(departementDto, HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping
    public ResponseEntity<Departement> saveDepartement(@RequestBody DepartementDto departementDto) throws DepartementNotFindException {
        Departement departement = departementService.saveDepartement(departementDto);
        return new ResponseEntity<>(departement,HttpStatus.CREATED);

    }

    @PutMapping("/{id}")
    public ResponseEntity<Departement> updateDepartement(@RequestBody DepartementDto departementDto,
                                                         @PathVariable Long id) throws DepartementNotFindException {

        DepartementDto departementExistant = departementService.getDepartement(id);
        if (departementExistant != null) {
            departementExistant.setNomDepartement(departementDto.getNomDepartement());
            departementExistant.setCreateby(departementDto.getCreateby());
            departementExistant.setCreateAt(departementDto.getCreateAt());
            Departement departement = departementService.updateDepartement(departementExistant,id);
            return new ResponseEntity<>(departement,HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDepartement(@PathVariable Long id) throws DepartementNotFindException {
        DepartementDto departementDto = departementService.getDepartement(id);
        if (departementDto != null) {
            departementService.deleteDepartement(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
