package sn.uasz.ParametresAPI.services;

import sn.uasz.ParametresAPI.dto.NiveauDto;
import sn.uasz.ParametresAPI.entities.Niveau;
import sn.uasz.ParametresAPI.exceptions.NiveauNotFindException;
import sn.uasz.ParametresAPI.mappers.NiveauMapper;
import sn.uasz.ParametresAPI.repository.NiveauRepository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class NiveauService {

    private final NiveauRepository niveauRepository;

    public NiveauService(NiveauRepository niveauRepository) {
        this.niveauRepository = niveauRepository;
    }

    public NiveauDto save(NiveauDto dto) {
        Niveau niveau = NiveauMapper.toEntity(dto);
        return NiveauMapper.toDto(niveauRepository.save(niveau));
    }

    public NiveauDto update(Long id, NiveauDto dto) {
        Niveau niveau = niveauRepository.findById(id)
                .orElseThrow(() -> new NiveauNotFindException("Niveau introuvable avec ID: " + id));
        niveau.setNom(dto.getNom());
        return NiveauMapper.toDto(niveauRepository.save(niveau));
    }

    public NiveauDto getById(Long id) {
        Niveau niveau = niveauRepository.findById(id)
                .orElseThrow(() -> new NiveauNotFindException("Niveau introuvable avec ID: " + id));
        return NiveauMapper.toDto(niveau);
    }

    public void delete(Long id) {
        if (!niveauRepository.existsById(id)) {
            throw new NiveauNotFindException("Niveau introuvable avec ID: " + id);
        }
        niveauRepository.deleteById(id);
    }

    public List<NiveauDto> getAll() {
        return niveauRepository.findAll().stream()
                .map(NiveauMapper::toDto)
                .collect(Collectors.toList());
    }

    public List<NiveauDto> searchByNom(String nom) {
        return niveauRepository.findByNomContainingIgnoreCase(nom).stream()
                .map(NiveauMapper::toDto)
                .collect(Collectors.toList());
    }

    public Page<NiveauDto> getAllPaged(Pageable pageable) {
        return niveauRepository.findAll(pageable)
                .map(NiveauMapper::toDto);
    }
}