package com.tlaxcala.model;
import lombok.*;
//import java.util.Objects;

/*@Getter
@Setter
@ToString*/
@Data
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class Patient {
    
    private Integer idPatient;
    private String firstName;


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
