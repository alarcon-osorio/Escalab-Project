package com.tlaxcala.model;
import jakarta.persistence.*;
import lombok.*;
//import java.util.Objects;

/*@Getter
@Setter
@ToString*/
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@NoArgsConstructor
@AllArgsConstructor
@Entity
//@Table(name = "tbl_patient")
public class Patient {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Integer idPatient;

    @Column(length = 70, nullable = false)
    private String firstName;

    @Column(length = 70, nullable = false)
    private String lastName;

    @Column(length = 8, nullable = false)
    private String dni;

    @Column(length = 150, nullable = false)
    private String address;

    @Column(length = 9, nullable = false)
    private String phone;

    @Column(length = 55, nullable = false)
    private String email;

    /*public Patient() {
    }

    public Patient(Integer idPatient, String firstName) {
        this.idPatient = idPatient;
        this.firstName = firstName;
    }

    public Integer getIdPatient() {
        return this.idPatient;
    }

    public void setIdPatient(Integer idPatient) {
        this.idPatient = idPatient;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public Patient idPatient(Integer idPatient) {
        setIdPatient(idPatient);
        return this;
    }

    public Patient firstName(String firstName) {
        setFirstName(firstName);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Patient)) {
            return false;
        }
        Patient patient = (Patient) o;
        return Objects.equals(idPatient, patient.idPatient) && Objects.equals(firstName, patient.firstName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idPatient, firstName);
    }

    @Override
    public String toString() {
        return "{" +
            " idPatient='" + getIdPatient() + "'" +
            ", firstName='" + getFirstName() + "'" +
            "}";
    }  */  
}
