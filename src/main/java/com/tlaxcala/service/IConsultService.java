package com.tlaxcala.service;

import java.util.List;

import com.tlaxcala.model.Consult;
import com.tlaxcala.model.Exam;

public interface IConsultService extends ICRUD<Consult, Integer> {

    Consult saveTransactional(Consult consult, List<Exam> exams);

}
