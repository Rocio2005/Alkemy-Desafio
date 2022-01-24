package com.alkemy.disney.service.implementaciones;

import com.alkemy.disney.DTO.GeneroDTO;
import com.alkemy.disney.entity.GeneroEntity;
import com.alkemy.disney.mapper.GeneroMapper;
import com.alkemy.disney.repository.GeneroRepository;
import com.alkemy.disney.service.GeneroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service //aca recien se hace toda la lógica, por qué??
public class GeneroServiceImp implements GeneroService {

    @Autowired
    private GeneroMapper generoMapper;
    @Autowired
    private GeneroRepository generoRepository;

    public GeneroDTO save (GeneroDTO dto){
        GeneroEntity entity = generoMapper.generoDTOTOEntity(dto);
        GeneroEntity entitySaved=generoRepository.save(entity);
        GeneroDTO result= generoMapper.generoEntityToDTO(entitySaved);
        System.out.println("GUARDAR GENERO");
        return result;
    }
    public List<GeneroDTO> getAllGeneros(){
        List<GeneroEntity> entities=generoRepository.findAll();
        List<GeneroDTO> result=generoMapper.generoEntityListToDTOList(entities);
        return result;
    }
}
