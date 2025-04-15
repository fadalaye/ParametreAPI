package sn.uasz.ParametresAPI.entities;

import jakarta.persistence.*;

@Entity // Vérifiez cette annotation !
@Table(name = "groupes")

//@ToString(exclude = {"etudiants", "enseignants"})
public class Groupe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Stratégie standard pour auto-incrément
    private Long id;

    @Column(nullable = false, length = 100)
    private String nom;

    @Column(length = 50)
    private String typeGroupe;

    private int capacite;



    private String createdBy;

    @Column(length = 50)
    private String createdAt;

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

    public String getTypeGroupe() {
        return typeGroupe;
    }

    public void setTypeGroupe(String typeGroupe) {
        this.typeGroupe = typeGroupe;
    }

    public int getCapacite() {
        return capacite;
    }

    public void setCapacite(int capacite) {
        this.capacite = capacite;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }
}