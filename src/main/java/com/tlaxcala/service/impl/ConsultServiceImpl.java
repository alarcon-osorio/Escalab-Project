package com.tlaxcala.service.impl;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;

import com.tlaxcala.model.Consult;
import com.tlaxcala.model.Exam;
import com.tlaxcala.repo.IGenericRepo;
import com.tlaxcala.repo.IConsultExamRepo;
import com.tlaxcala.repo.IConsultRepo;
import com.tlaxcala.service.IConsultService;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ConsultServiceImpl extends CRUDImpl<Consult, Integer> implements IConsultService {

    private final IConsultRepo consultRepo;
    private final IConsultExamRepo ceRepo;

    @Override
    protected IGenericRepo<Consult, Integer> getRepo() {
        return consultRepo;
    }

    @Transactional
    @Override
    public Consult saveTransactional(Consult consult, List<Exam> exams) {
        // consulta con su maestro detalle
        consultRepo.save(consult);
        // list exams
        exams.forEach(ex -> ceRepo.saveExam(consult.getIdConsult(), ex.getIdExam()));

        return consult;
    }

    @Override
    public List<Consult> search(String dni, String fullname) {
        return consultRepo.search(dni, fullname);
    }

    @Override
    public List<Consult> searchByDates(LocalDateTime date1, LocalDateTime date2) {
       final int OFFSET_DAYS = 1;
       return consultRepo.searchByDates(date1, date2.plusDays(OFFSET_DAYS));
    }

}
