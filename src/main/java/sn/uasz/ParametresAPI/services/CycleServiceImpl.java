package sn.uasz.ParametresAPI.services;


import sn.uasz.ParametresAPI.dto.CycleDto;
import sn.uasz.ParametresAPI.entities.Cycle;
import sn.uasz.ParametresAPI.exceptions.CycleNotFoundException;
import sn.uasz.ParametresAPI.mappers.CycleMapper;
import sn.uasz.ParametresAPI.repository.CycleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CycleServiceImpl implements CycleService {

    private final CycleRepository repository;

    @Override
    public CycleDto createCycle(CycleDto dto) {
        Cycle saved = repository.save(CycleMapper.toEntity(dto));
        return CycleMapper.toDto(saved);
    }

    @Override
    public CycleDto updateCycle(Long id, CycleDto dto) {
        Cycle existing = repository.findById(id)
                .orElseThrow(() -> new CycleNotFoundException("Cycle non trouvé avec l'id " + id));
        existing.setNom(dto.getNom());
        return CycleMapper.toDto(repository.save(existing));
    }

    @Override
    public void deleteCycle(Long id) {
        if (!repository.existsById(id)) {
            throw new CycleNotFoundException("Cycle non trouvé avec l'id " + id);
        }
        repository.deleteById(id);
    }

    @Override
    public CycleDto getCycle(Long id) {
        return repository.findById(id)
                .map(CycleMapper::toDto)
                .orElseThrow(() -> new CycleNotFoundException("Cycle non trouvé avec l'id " + id));
    }

    @Override
    public List<CycleDto> getAllCycles() {
        return repository.findAll()
                .stream()
                .map(CycleMapper::toDto)
                .collect(Collectors.toList());
    }
}
