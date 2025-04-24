package sn.uasz.ParametresAPI.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import sn.uasz.ParametresAPI.dto.CycleDTO;
import sn.uasz.ParametresAPI.entities.Cycle;
import sn.uasz.ParametresAPI.exceptions.ClasseNotFoundException;
import sn.uasz.ParametresAPI.exceptions.CycleNotFoundException;
import sn.uasz.ParametresAPI.mappers.CycleMapper;
import sn.uasz.ParametresAPI.repository.CycleRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CycleService {

    @Autowired
    private CycleRepository cycleRepository;

    @Autowired
    private CycleMapper cycleMapper;

    public CycleDTO create(CycleDTO dto) {
        if (cycleRepository.existsByNom(dto.getNom())) {
            throw new IllegalArgumentException("Ce nom de cycle existe déjà !");
        }
        Cycle cycle = cycleMapper.toEntity(dto);
        return cycleMapper.toDto(cycleRepository.save(cycle));
    }

    public List<CycleDTO> getAll() {
        return cycleRepository.findAll().stream()
                .map(cycleMapper::toDto)
                .collect(Collectors.toList());
    }

    public CycleDTO getById(Long id) {
        Cycle cycle = cycleRepository.findById(id)
                .orElseThrow(() -> new CycleNotFoundException("Cycle non trouvé avec ID " + id));
        return cycleMapper.toDto(cycle);
    }

    public CycleDTO update(Long id, CycleDTO dto) {
        Cycle existing = cycleRepository.findById(id)
                .orElseThrow(() -> new CycleNotFoundException("Cycle non trouvé avec ID " + id));
        existing.setNom(dto.getNom());
        return cycleMapper.toDto(cycleRepository.save(existing));
    }

    public void delete(Long id) {
        if (!cycleRepository.existsById(id)) {
            throw new CycleNotFoundException("Cycle non trouvé avec ID " + id);
        }
        cycleRepository.deleteById(id);
    }
}

