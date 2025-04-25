package sn.uasz.ParametresAPI.repository;

import lombok.AllArgsConstructor;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import sn.uasz.ParametresAPI.entities.Departement;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class DepartementRepositoryTest {
    @Autowired
    DepartementRepository departementRepository;
    @Test
    void listDepatement(){
        //act
        List<Departement> departements = departementRepository.findAll();
        // Assert
        assertEquals(3, departements.size());
        System.out.println(departements);
        assertEquals("Informatique", departements.get(0).getNomDepartement());

    }

    @Test
    void  getDepartementById(){
        Departement departement = departementRepository.findById(1L).get();

        assertEquals("Informatique",departement.getNomDepartement());
        assertEquals("2024-02-10",departement.getCreateAt());

    }

    @Test
    void saveDepartement(){
        Departement departement = new Departement();
        departement.setNomDepartement("Chimie");
        departement.setCreateAt("2024-02-10");
        departement.setCreateby("2");
        Departement departement1 = departementRepository.save(departement);

        assertNotNull(departement1.getId());
    }

    @Test
    void updateDepartement(){
        Departement departement = departementRepository.findById(1L).get();
        departement.setNomDepartement("Chimie");

        Departement departement1 = departementRepository.save(departement);
        assertEquals("Chimie",departement1.getNomDepartement());
    }

    @Test
    void deleteDepartement(){
        departementRepository.deleteById(2L);

        Optional<Departement> departement = departementRepository.findById(2L);
        assertFalse(departement.isPresent());

    }

}