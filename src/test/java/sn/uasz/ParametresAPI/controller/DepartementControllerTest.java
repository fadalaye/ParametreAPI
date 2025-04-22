package sn.uasz.ParametresAPI.controller;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.TestConfiguration;

import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.mockito.ArgumentMatchers.any;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockReset;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import sn.uasz.ParametresAPI.dto.DepartementDto;
import sn.uasz.ParametresAPI.entities.Departement;
import sn.uasz.ParametresAPI.exceptions.DepartementNotFindException;
import sn.uasz.ParametresAPI.mappers.DepartementMapper;
import sn.uasz.ParametresAPI.repository.DepartementRepository;
import sn.uasz.ParametresAPI.services.DepartementService;

import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(DepartementController.class)
class DepartementControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    DepartementService departementService;
    @Autowired
    DepartementMapper departementMapper;

    @Autowired
    DepartementRepository departementRepository;

    @TestConfiguration
    public static class TestConfig {

        @Bean
        @Primary
        public DepartementService departementService() {
            return Mockito.mock(DepartementService.class);
        }

        @Bean
        @Primary
        public DepartementMapper departementMapper() {
            return Mockito.mock(DepartementMapper.class); // Bien
        }


        @Bean
        @Primary
        public DepartementRepository departementRepository() {
            return Mockito.mock(DepartementRepository.class);
        }
    }

    @Test
    void getAllDepartements() throws Exception {

        Departement d1 = new Departement(1L, "Informatique", "1", "2024-02-10");
        Departement d2 = new Departement(2L, "Physique", "1", "2024-02-12");
        Departement d3 = new Departement(3L, "Geographie", "1", "2024-02-10");

        DepartementDto dto1 = new DepartementDto(1L, "Informatique", "1", "2024-02-10");
        DepartementDto dto2 = new DepartementDto(2L, "Physique", "1", "2024-02-12");
        DepartementDto dto3 = new DepartementDto(3L, "Geographie", "1", "2024-02-10");

        when(departementRepository.findAll()).thenReturn(List.of(d1, d2, d3));
        when(departementMapper.toDto(d1)).thenReturn(dto1);
        when(departementMapper.toDto(d2)).thenReturn(dto2);
        when(departementMapper.toDto(d3)).thenReturn(dto3);

        // 2. Configuration du mock du service
        when(departementService.getAllDepartements()).thenReturn(List.of(dto1, dto2, dto3));

        // 3. Exécution et vérification
        mockMvc.perform(get("/api/departement"))  // Notez le pluriel cohérent
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(3)))
                .andExpect(jsonPath("$[0].nomDepartement").value("Informatique"))
                .andExpect(jsonPath("$[1].nomDepartement").value("Physique"))
                .andExpect(jsonPath("$[2].nomDepartement").value("Geographie"));
    }

    @Test
    void getDepartementById() throws Exception {
        Departement d1 = new Departement(1L, "Informatique", "1", "2024-02-10");

        DepartementDto dto1 = new DepartementDto(1L, "Informatique", "1", "2024-02-10");

        when(departementRepository.findById(1L)).thenReturn(Optional.of(d1));
        when(departementMapper.toDto(d1)).thenReturn(dto1);

        when(departementService.getDepartement(1L)).thenReturn(dto1);

        mockMvc.perform(get("/api/departement/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.nomDepartement").value("Informatique"))
                .andExpect(jsonPath("$.createby").value("1"))
                .andExpect(jsonPath("$.createAt").value("2024-02-10"));



    }

    @Test
    void saveDepartement() throws Exception {
        Departement d1 = new Departement(1L, "Informatique", "1", "2024-02-10");

        DepartementDto dto1 = new DepartementDto(1L, "Informatique", "1", "2024-02-10");

        String json = """
                {
                "id": 1,
                "nomDepartement": "Informatique",
                "createby": "1",
                "createAt": "2024-02-10"
                }
                """;

        when(departementMapper.toEntity(dto1)).thenReturn(d1);
//        when(departementRepository.save(d1)).thenReturn(d1);

        when(departementService.saveDepartement(dto1)).thenReturn(d1);

        mockMvc.perform(post("/api/departement").contentType(MediaType.APPLICATION_JSON).content(json))
                .andExpect(status().isCreated());
        // .andExpect(jsonPath("$.id").value(1));

    }

    @Test
    void updateDepartement() throws Exception {
        Departement departNouveau = new Departement(1L, "Physique", "1", "2024-02-12");

        DepartementDto dtoExistant = new DepartementDto(1L, "Informatique", "1", "2024-02-10");
        DepartementDto dtoNouveau = new DepartementDto(1L, "Physique", "1", "2024-02-12");

        String json = """
                {
                "id": 1,
                "nomDepartement": "Physique",
                "createby": "1",
                "createAt": "2024-02-12"
                }
                """;

        when(departementService.getDepartement(1L)).thenReturn(dtoExistant);
        when(departementService.updateDepartement(dtoNouveau,1L)).thenReturn(departNouveau);

        MvcResult reset = mockMvc.perform(put("/api/departement/1").contentType(MediaType.APPLICATION_JSON).content(json))
                .andExpect(status().isOk())
                //.andExpect(jsonPath("$.nomDepartement").value(departNouveau.getNomDepartement()))
                .andReturn();
        System.out.println("Response JSON: " + reset.getResponse().getContentAsString());

    }

    @Test
    void deleteDepartement() throws Exception {
        Departement departNouveau = new Departement(1L, "Physique", "1", "2024-02-12");
        DepartementDto dtoExistant = new DepartementDto(1L, "Informatique", "1", "2024-02-10");
        when(departementService.getDepartement(1L)).thenReturn(dtoExistant);

        mockMvc.perform(delete("/api/departement/1"))
                .andExpect(status().isOk());

    }

}