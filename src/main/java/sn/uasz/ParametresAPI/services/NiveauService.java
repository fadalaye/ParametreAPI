package sn.uasz.ParametresAPI.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sn.uasz.ParametresAPI.dto.NiveauDto;
import sn.uasz.ParametresAPI.entities.Niveau;
import sn.uasz.ParametresAPI.exceptions.NiveauNotFindException;
import sn.uasz.ParametresAPI.mappers.NiveauMapper;
import sn.uasz.ParametresAPI.repository.NiveauRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class NiveauService {

    private final NiveauRepository niveauRepository;

    @Autowired
    public NiveauService(NiveauRepository niveauRepository) {
        this.niveauRepository = niveauRepository;
    }

    // Ajouter un nouveau niveau
    public NiveauDto save(NiveauDto niveauDto) {
        Niveau niveau = NiveauMapper.toEntity(niveauDto);
        Niveau savedNiveau = niveauRepository.save(niveau);
        return NiveauMapper.toDto(savedNiveau);
    }

    // Récupérer tous les niveaux
    public List<NiveauDto> getAll() {
        List<Niveau> niveaux = niveauRepository.findAll();
        return niveaux.stream()
                .map(NiveauMapper::toDto)
                .collect(Collectors.toList());
    }

    // Récupérer un niveau par ID
    public NiveauDto getNiveau(Long id) {
        Niveau niveau = niveauRepository.findById(id)
                .orElseThrow(() -> new NiveauNotFindException("Niveau introuvable"));
        return NiveauMapper.toDto(niveau);
    }

    // Mettre à jour un niveau
    public NiveauDto update(Long id, NiveauDto niveauDto) {
        Niveau niveau = niveauRepository.findById(id)
                .orElseThrow(() -> new NiveauNotFindException("Niveau introuvable"));
        niveau.setNom(niveauDto.getNom());
        Niveau updatedNiveau = niveauRepository.save(niveau);
        return NiveauMapper.toDto(updatedNiveau);
    }

    // Supprimer un niveau
    public void delete(Long id) {
        if (!niveauRepository.existsById(id)) {
            throw new NiveauNotFindException("Niveau introuvable");
        }
        niveauRepository.deleteById(id);
    }
}
