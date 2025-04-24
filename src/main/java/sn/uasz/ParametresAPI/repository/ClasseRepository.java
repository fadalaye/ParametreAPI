package sn.uasz.ParametresAPI.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import sn.uasz.ParametresAPI.entities.Classe;

public interface ClasseRepository extends JpaRepository<Classe, Long> {
    boolean existsByNom(String nom);
}
