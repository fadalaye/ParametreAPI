package sn.uasz.ParametresAPI.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import sn.uasz.ParametresAPI.dto.FormationDto;
import sn.uasz.ParametresAPI.entities.Formation;
import sn.uasz.ParametresAPI.exceptions.FormationNotFindException;
import sn.uasz.ParametresAPI.services.FormationServiceImpl;


import java.util.List;

@RestController
@CrossOrigin("*")
@AllArgsConstructor
public class FormationRestController {
    private FormationServiceImpl formationService;

    @GetMapping("/formationById/{id}")
    public FormationDto formationById(@PathVariable Long id) throws FormationNotFindException {
        return formationService.findFormationById(id);
    }

    @PostMapping("/saveFormation")
    public Formation saveFormation(FormationDto formation) throws FormationNotFindException {
        return formationService.saveFormation(formation);
    }

    @GetMapping("/listeFormation")
    public List<FormationDto> findAllFormationt() {
        return formationService.findAllFormation();
    }

    @PostMapping("/updateFormation/{id}")
    public Formation updateFormation(@PathVariable Long id,FormationDto formationDto) throws FormationNotFindException {
        return formationService.updateFormation(id, formationDto);
    }

    @GetMapping("/deleteFormation/{id}")
    public void deleteFormationById(@PathVariable Long id) throws FormationNotFindException {
        formationService.deleteFormation(id);
    }


}
