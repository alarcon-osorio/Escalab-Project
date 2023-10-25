package com.tlaxcala.repo;

import org.springframework.data.jpa.repository.JpaRepository;

public interface IGenericRepo<T, ID> extends JpaRepository<T, ID> {
    
}
