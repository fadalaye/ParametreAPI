package sn.uasz.ParametresAPI.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import sn.uasz.ParametresAPI.entities.Niveau;

public interface NiveauRepository extends JpaRepository<Niveau, Long> {
    Page<Niveau> findByNomContainingIgnoreCase(String nom, Pageable pageable);
}
