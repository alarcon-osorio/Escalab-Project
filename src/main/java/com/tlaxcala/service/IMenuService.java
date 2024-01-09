package com.tlaxcala.service;

import java.util.List;

import com.tlaxcala.model.Menu;

public interface IMenuService extends ICRUD<Menu, Integer> {
    
    List<Menu> getMenusByUsername(String username);
}
