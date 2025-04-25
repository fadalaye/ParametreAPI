package sn.uasz.ParametresAPI.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import sn.uasz.ParametresAPI.entities.Formation;

import java.util.List;

@RepositoryRestResource
public interface FormationRepository extends JpaRepository<Formation, Long> {
    public List<Formation> findByLibelleContainsIgnoreCase(String kw);

}
