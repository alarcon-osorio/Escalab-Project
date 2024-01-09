package com.tlaxcala.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class MenuDTO {
    
    @EqualsAndHashCode.Include
    private Integer idMenu;

    private String icon;
    private String name;
    private String url;
    private List<RolDTO> roles;
}
