package com.tlaxcala.model;

import jakarta.persistence.*;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@IdClass(ConsultExamPK.class)
public class ConsultExam {
    
    @Id
    private Consult consult;

    @Id
    private Exam exam;

}

