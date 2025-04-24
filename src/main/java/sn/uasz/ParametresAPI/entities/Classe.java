package sn.uasz.ParametresAPI.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/* @Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter */
public class Classe {

    /* @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom;
    @ManyToOne
    @JoinColumn(name = "niveau_id")
    private Niveau niveau;
    private int nbrEtudiant;
    @ManyToOne
    @JoinColumn(name = "formation_id")
    private Formation formation;
    @ManyToOne
    private Cycle cycle;
    @ManyToOne
    private Salle salle;
    @ManyToOne
    @JoinColumn(name = "semestre_id")
    private Semestre semestre;

    private String createby;
    private String createat; */

}
