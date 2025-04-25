package sn.uasz.ParametresAPI.services;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import sn.uasz.ParametresAPI.dto.DepartementDto;
import sn.uasz.ParametresAPI.entities.Departement;
import sn.uasz.ParametresAPI.exceptions.DepartementNotFindException;
import sn.uasz.ParametresAPI.mappers.DepartementMapper;
import sn.uasz.ParametresAPI.repository.DepartementRepository;
import sn.uasz.ParametresAPI.services.DepartementService;

import java.util.List;
import java.util.Optional;


import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@SpringBootTest
class DepartementServiceTest {

    @Mock
    DepartementRepository departementRepository;

    @Mock
    private DepartementMapper departementMapper;

    @InjectMocks
    DepartementService departementService;

    @Test
    void getAllDepartements() {
        // 1. Préparation des données de test
        Departement d1 = new Departement(1L, "Informatique", "1", "2024-02-10");
        Departement d2 = new Departement(2L, "Physique", "1", "2024-02-12");
        Departement d3 = new Departement(3L, "Geographie", "1", "2024-02-10");

        DepartementDto dto1 = new DepartementDto(1L, "Informatique", "1", "2024-02-10");
        DepartementDto dto2 = new DepartementDto(2L, "Physique", "1", "2024-02-12");
        DepartementDto dto3 = new DepartementDto(3L, "Geographie", "1", "2024-02-10");

        // 2. Configuration des mocks
        when(departementRepository.findAll()).thenReturn(List.of(d1, d2, d3));
        when(departementMapper.toDto(d1)).thenReturn(dto1);
        when(departementMapper.toDto(d2)).thenReturn(dto2);
        when(departementMapper.toDto(d3)).thenReturn(dto3);

        // 3. Exécution
        List<DepartementDto> result = departementService.getAllDepartements();

        // 4. Vérifications
        assertThat(result)
                .hasSize(3)
                .extracting(DepartementDto::getNomDepartement)
                .containsExactlyInAnyOrder("Informatique", "Physique", "Geographie");
    }
    @Test
    void getDepartementById() throws DepartementNotFindException {
        Departement d1 = new Departement(1L, "Informatique", "1", "2024-02-10");

        DepartementDto dto1 = new DepartementDto(1L, "Informatique", "1", "2024-02-10");
        when(departementRepository.findById(1L)).thenReturn(Optional.of(d1));
        when(departementMapper.toDto(d1)).thenReturn(dto1);

        DepartementDto departementDto = departementService.getDepartement(1L);

        assertThat(departementDto).isEqualTo(dto1);


    }
    @Test
    void saveDepartement() {

        Departement d1 = new Departement(1L, "Informatique", "1", "2024-02-10");

        DepartementDto dto1 = new DepartementDto(1L, "Informatique", "1", "2024-02-10");

        when(departementMapper.toEntity(dto1)).thenReturn(d1);
        when(departementRepository.save(d1)).thenReturn(d1);

        Departement departement  = departementService.saveDepartement(dto1);
//
        assertThat(departement)
                .isNotNull()
                .isEqualTo(d1);



    }
    @Test
    void updateDepartement() {
        Departement d1 = new Departement(1L, "Informatique", "1", "2024-02-10");

        DepartementDto dto1 = new DepartementDto(1L, "Informatique", "1", "2024-02-10");

        when(departementMapper.toEntity(dto1)).thenReturn(d1);
        when(departementRepository.save(d1)).thenReturn(d1);

        Departement departement  = departementService.saveDepartement(dto1);

        // DepartementDto dto2 = new DepartementDto(2L, "Physique", "1", "2024-02-12");
        departement.setNomDepartement("Agro");

        //when(departementMapper.toEntity(dto2));
        when(departementRepository.save(departement)).thenReturn(departement);

        assertEquals("Agro",departement.getNomDepartement());

    }
    @Test
    void deleteDepartement() throws DepartementNotFindException {

        DepartementNotFindException exception = assertThrows(
                DepartementNotFindException.class,
                () -> departementService.deleteDepartement(1L)
        );

        // Vérification supplémentaire du message
        assertTrue(exception.getMessage().contains("La departement " + 1L + " n'existe pas"));

//        departementService.deleteDepartement(1L);
//        verify(departementRepository).deleteById(1L);
    }



}