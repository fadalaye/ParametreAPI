package sn.uasz.ParametresAPI.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import sn.uasz.ParametresAPI.dto.CycleDTO;
import sn.uasz.ParametresAPI.services.CycleService;

import java.util.List;

@RestController
@RequestMapping("/api/cycles")
@CrossOrigin("*")
public class CycleController {

    @Autowired
    private CycleService cycleService;

    @PostMapping
    public ResponseEntity<CycleDTO> create(@RequestBody CycleDTO dto) {
        return ResponseEntity.ok(cycleService.create(dto));
    }

    @GetMapping
    public ResponseEntity<List<CycleDTO>> getAll() {
        return ResponseEntity.ok(cycleService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<CycleDTO> getById(@PathVariable Long id) {
        return ResponseEntity.ok(cycleService.getById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<CycleDTO> update(@PathVariable Long id, @RequestBody CycleDTO dto) {
        return ResponseEntity.ok(cycleService.update(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        cycleService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
