package sn.uasz.ParametresAPI.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import sn.uasz.ParametresAPI.entities.Cycle;

@Repository
public interface CycleRepository extends JpaRepository<Cycle, Long> {
    boolean existsByNom(String nom);
}

