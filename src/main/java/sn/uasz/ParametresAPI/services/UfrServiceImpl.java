package sn.uasz.ParametresAPI.services;

import org.springframework.stereotype.Service;
import sn.uasz.ParametresAPI.dto.UfrDto;
import sn.uasz.ParametresAPI.entities.Ufr;
import sn.uasz.ParametresAPI.exceptions.ResourceNotFoundException;
import sn.uasz.ParametresAPI.mappers.UfrMapper;
import sn.uasz.ParametresAPI.repository.UfrRepository;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UfrServiceImpl implements UfrService {

    private final UfrRepository repository;
    private final UfrMapper mapper;

    public UfrServiceImpl(UfrRepository repository, UfrMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public UfrDto create(UfrDto dto) {
        Ufr ufr = mapper.toEntity(dto);
        return mapper.toDto(repository.save(ufr));
    }

    @Override
    public UfrDto update(Long id, UfrDto dto) {
        Ufr ufr = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("UFR non trouvée"));
        ufr.setNom(dto.getNom());
        ufr.setCreateby(dto.getCreateby());
        ufr.setCreateat(dto.getCreateat());
        return mapper.toDto(repository.save(ufr));
    }

    @Override
    public void delete(Long id) {
        if (!repository.existsById(id)) {
            throw new ResourceNotFoundException("UFR non trouvée");
        }
        repository.deleteById(id);
    }

    @Override
    public UfrDto getById(Long id) {
        return mapper.toDto(repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("UFR non trouvée")));
    }

    @Override
    public List<UfrDto> searchByNom(String nom) {
        return repository.findByNomContainingIgnoreCase(nom)
                .stream().map(mapper::toDto).collect(Collectors.toList());
    }

    @Override
    public List<UfrDto> getAll() {
        return repository.findAll()
                .stream().map(mapper::toDto).collect(Collectors.toList());
    }
}


