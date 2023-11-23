package com.tlaxcala.repo;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.repository.query.Param;

import com.tlaxcala.model.Consult;

public interface IConsultRepo extends IGenericRepo<Consult, Integer> { 

    // new querys
    List<Consult> search(@Param("dni") String dni, @Param("fullname") String fullname);
    List<Consult> searchByDates(@Param("date1") LocalDateTime date1, @Param("date2") LocalDateTime date2);
    List<Object[]> callProcedureOrFunctionNative();
    //List<IConsultProcDTO> callProcedureOrFunctionProjection();
}
