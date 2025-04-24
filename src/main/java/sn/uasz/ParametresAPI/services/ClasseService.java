package sn.uasz.ParametresAPI.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sn.uasz.ParametresAPI.dto.ClasseDTO;
import sn.uasz.ParametresAPI.entities.Classe;
import sn.uasz.ParametresAPI.exceptions.ClasseNotFoundException;
import sn.uasz.ParametresAPI.mappers.ClasseMapper;
import sn.uasz.ParametresAPI.repository.ClasseRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClasseService {

    /* @Autowired
    private ClasseRepository classeRepository;

    @Autowired
    private ClasseMapper classeMapper;

    public ClasseDTO create(ClasseDTO dto) {
        if (classeRepository.existsByNom(dto.getNom())) {
            throw new IllegalArgumentException("Ce nom de classe existe déjà !");
        }
        Classe classe = classeMapper.toEntity(dto);
        return classeMapper.toDto(classeRepository.save(classe));
    }

    public List<ClasseDTO> getAll() {
        return classeRepository.findAll().stream()
                .map(classeMapper::toDto)
                .collect(Collectors.toList());
    }

    public ClasseDTO getById(Long id) {
        Classe classe = classeRepository.findById(id)
                .orElseThrow(() -> new ClasseNotFoundException("Classe non trouvée avec l'ID " + id));
        return classeMapper.toDto(classe);
    }

    public ClasseDTO update(Long id, ClasseDTO dto) {
        Classe existing = classeRepository.findById(id)
                .orElseThrow(() -> new ClasseNotFoundException("Classe non trouvée avec l'ID " + id));
        existing.setNom(dto.getNom());
        existing.setNbrEtudiant(dto.getNbrEtudiant());
        existing.setCreateat(dto.getCreateat());
        existing.setCreateby(dto.getCreateby());
        return classeMapper.toDto(classeRepository.save(existing));
    }

    public void delete(Long id) {
        if (!classeRepository.existsById(id)) {
            throw new ClasseNotFoundException("Classe non trouvée avec l'ID " + id);
        }
        classeRepository.deleteById(id);
    } */
}

