package sn.uasz.ParametresAPI.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sn.uasz.ParametresAPI.entities.Ufr;

import java.util.List;

@Repository
public interface UfrRepository extends JpaRepository<Ufr, Long> {
    List<Ufr> findByNomContainingIgnoreCase(String nom);
}

