package com.tlaxcala.model;

import java.io.Serializable;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.EqualsAndHashCode;

@Embeddable
@EqualsAndHashCode
public class ConsultExamPK implements Serializable {
    
    // clase que maneja las relaciones
    @ManyToOne
    @JoinColumn(name = "id_consult", nullable = false)
    private Consult consult;

    @ManyToOne
    @JoinColumn(name = "id_exam", nullable = false)
    private Exam exam;

}

// BENIFICIOS VS. FORMA 2
// 1. MAYOR FLEXIBILIDAD DE COMPORTAMIENTO
// 2. VERIFICACIÓN DE IGUAL DE OBJETOS DE INSTANCIAS
