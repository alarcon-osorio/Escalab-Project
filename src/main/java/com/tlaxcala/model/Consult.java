package com.tlaxcala.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.*;
import lombok.*;

@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Consult {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Integer idConsult;

    // relations
    // consult -> id_Consult | id_patient | id_medic | id_specialty | consult_date, etc.....
    //                  1    | 1 
    // jpa con hibernate -> jpql -> mediante objetos -> ORM/ODM
    
    @ManyToOne
    @JoinColumn(name = "id_patient", nullable = false, foreignKey = @ForeignKey(name = "FK_CONSULT_PATIENT"))
    private Patient patient;
    
    @ManyToOne
    @JoinColumn(name = "id_medic", nullable = false, foreignKey = @ForeignKey(name = "FK_CONSULT_MEDIC"))
    private Medic medic;

    @ManyToOne
    @JoinColumn(name = "id_specialty", nullable = false, foreignKey = @ForeignKey(name = "FK_CONSULT_SPECIALTY"))
    private Specialty specialty;

    @OneToMany(mappedBy = "consult", cascade = CascadeType.ALL, orphanRemoval = true) // fetchType.LAZY
    private List<ConsultDetail> details;

    // fetchType = eager | lazy -> default lazy

    // patient -> id_patient | first_name | last_name | etc...
    // medic -> id_medic | first_name | last_name | etc...
    // specialty -> id_specialty | first_name | last_name | id_consult | etc...

    // @Temporal: esto era para definir una propiedad como fecha, versiones inferiores a java 8
    // LocalDate: si solo necesitas la fecha
    // LocalDateTime: si necesitas la fecha y la hora
    private LocalDateTime consultDate;
 
}
