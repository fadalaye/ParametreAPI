package sn.uasz.ParametresAPI.dto;

import lombok.Data;

@Data
public class ClasseDTO {
    private Long id;
    private String nom;
    private Long niveauId;
    private int nbrEtudiant;
    private Long formationId;
    private Long cycleId;
    private Long salleId;
    private Long semestreId;
    private String createby;
    private String createat;
}
