package sn.uasz.ParametresAPI.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import sn.uasz.ParametresAPI.dto.ClasseDTO;
import sn.uasz.ParametresAPI.services.ClasseService;

import java.util.List;

@RestController
@RequestMapping("/api/classes")
public class ClasseController {

  /*   @Autowired
    private ClasseService classeService;

    @PostMapping
    public ClasseDTO create(@RequestBody ClasseDTO dto) {
        return classeService.create(dto);
    }

    @GetMapping
    public List<ClasseDTO> getAll() {
        return classeService.getAll();
    }

    @GetMapping("/{id}")
    public ClasseDTO getById(@PathVariable Long id) {
        return classeService.getById(id);
    }

    @PutMapping("/{id}")
    public ClasseDTO update(@PathVariable Long id, @RequestBody ClasseDTO dto) {
        return classeService.update(id, dto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        classeService.delete(id);
    } */
}
