package sn.uasz.ParametresAPI.controller;


import sn.uasz.ParametresAPI.dto.CycleDto;
import sn.uasz.ParametresAPI.services.CycleService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cycles")
@RequiredArgsConstructor
public class CycleController {

    private final CycleService service;

    @PostMapping
    public CycleDto create(@RequestBody CycleDto dto) {
        return service.createCycle(dto);
    }

    @PutMapping("/{id}")
    public CycleDto update(@PathVariable Long id, @RequestBody CycleDto dto) {
        return service.updateCycle(id, dto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.deleteCycle(id);
    }

    @GetMapping("/{id}")
    public CycleDto getOne(@PathVariable Long id) {
        return service.getCycle(id);
    }

    @GetMapping
    public List<CycleDto> getAll() {
        return service.getAllCycles();
    }
}

