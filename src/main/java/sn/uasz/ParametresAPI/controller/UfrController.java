package sn.uasz.ParametresAPI.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sn.uasz.ParametresAPI.dto.UfrDto;
import sn.uasz.ParametresAPI.services.UfrService;

import java.util.List;

@RestController
@RequestMapping("/api/ufrs")
public class UfrController {

    private final UfrService service;

    public UfrController(UfrService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<UfrDto> create(@RequestBody UfrDto dto) {
        return ResponseEntity.ok(service.create(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<UfrDto> update(@PathVariable Long id, @RequestBody UfrDto dto) {
        return ResponseEntity.ok(service.update(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<UfrDto> getById(@PathVariable Long id) {
        return ResponseEntity.ok(service.getById(id));
    }

    @GetMapping("/search")
    public ResponseEntity<List<UfrDto>> search(@RequestParam String nom) {
        return ResponseEntity.ok(service.searchByNom(nom));
    }

    @GetMapping
    public ResponseEntity<List<UfrDto>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }
}

