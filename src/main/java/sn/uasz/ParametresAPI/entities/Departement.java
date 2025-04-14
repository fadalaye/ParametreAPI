package sn.uasz.ParametresAPI.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class Departement {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nomDepartement;
//    @ManyToOne
//    @JoinColumn(name = "ufrDepartmnt")
    //private Ufr ufrDepartmnt;

    //@OneToMany(mappedBy = "departement")
    //List<Formation> formations = new ArrayList<>();

    private String createby;
    private String createAt;
}
