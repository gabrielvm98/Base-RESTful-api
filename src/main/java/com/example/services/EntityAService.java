package com.example.services;

import com.example.dtos.CreateEntityADto;
import com.example.dtos.EntityADto;
import com.example.exceptions.GeneralException;

import java.util.List;


public interface EntityAService {
    EntityADto createEntityA(CreateEntityADto createEntityADto) throws GeneralException;
    List<EntityADto> getAllEntityA() throws GeneralException;
    EntityADto getEntityAById(Long id) throws GeneralException;
    EntityADto updateEntityA(Long id, CreateEntityADto createEntityADto) throws GeneralException;
    void deleteEntityA(Long id) throws GeneralException;
}
