package com.alkemy.disney.mapper;

import com.alkemy.disney.DTO.GeneroDTO;
import com.alkemy.disney.entity.GeneroEntity;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class GeneroMapper {

    public GeneroEntity generoDTOTOEntity(GeneroDTO dto){
        GeneroEntity generoEntity= new GeneroEntity();
        generoEntity.setImagen(dto.getImagen());
        generoEntity.setNombre(dto.getNombre());
        return generoEntity;
    }

    public GeneroDTO generoEntityToDTO(GeneroEntity entity){
        GeneroDTO dto= new GeneroDTO();
        dto.setId(entity.getId());
        dto.setNombre(entity.getNombre());
        dto.setImagen(entity.getImagen());
        return dto;

    }

    public List<GeneroDTO> generoEntityListToDTOList(List<GeneroEntity> entities){
        List<GeneroDTO> dtos=new ArrayList<>();
        for (GeneroEntity entity:entities){
            dtos.add(this.generoEntityToDTO(entity));
        }
        return dtos;
    }
}
