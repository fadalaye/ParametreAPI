    package sn.uasz.ParametresAPI.entities;

    import jakarta.persistence.*;
    import lombok.Data;

    @Entity
    @Data
    public class Ufr {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        private String nom;

        // Si besoin plus tard
        // @OneToMany(mappedBy = "ufr")
        // private List<Departement> departements;

        private String createby;
        private String createat;
    }

