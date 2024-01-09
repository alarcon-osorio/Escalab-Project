package com.tlaxcala.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.tlaxcala.model.Menu;
import com.tlaxcala.repo.IGenericRepo;
import com.tlaxcala.repo.IMenuRepo;
import com.tlaxcala.service.IMenuService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MenuServiceImpl extends CRUDImpl<Menu, Integer> implements IMenuService {

    private final IMenuRepo repo;

    @Override
    protected IGenericRepo<Menu, Integer> getRepo() {
        return repo;
    }
    
    public List<Menu> getMenusByUsername(String username) {
        //String contextSessionUser = SecurityContextHolder.getContext().getAuthentication().getName();
        return repo.getMenusByUsername(username);
    }

}
