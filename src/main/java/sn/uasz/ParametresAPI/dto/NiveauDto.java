package sn.uasz.ParametresAPI.dto;

import sn.uasz.ParametresAPI.entities.Niveau;

public class NiveauDto {

    private Long id;
    private String nom;

    // Constructeur par défaut
    public NiveauDto() {}

    // Constructeur avec paramètres
    public NiveauDto(Long id, String nom) {
        this.id = id;
        this.nom = nom;
    }

    // Getters et Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    // Méthode de conversion depuis l'entité Niveau
    public static NiveauDto fromEntity(Niveau niveau) {
        return new NiveauDto(niveau.getId(), niveau.getNom());
    }

    // Méthode pour convertir le DTO en entité Niveau
    public Niveau toEntity() {
        return new Niveau(id, nom);
    }
}
