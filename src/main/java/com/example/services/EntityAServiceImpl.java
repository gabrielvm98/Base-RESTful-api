package com.example.services;

import com.example.dtos.CreateEntityADto;
import com.example.dtos.EntityADto;
import com.example.entities.EntityA;
import com.example.exceptions.GeneralException;
import com.example.exceptions.InternalServerErrorException;
import com.example.exceptions.NotFoundException;
import com.example.repositories.EntityARepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EntityAServiceImpl implements EntityAService{

    public static final ModelMapper modelMapper = new ModelMapper();

    @Autowired
    private EntityARepository entityARepository;

    @Override
    public EntityADto createEntityA(CreateEntityADto createEntityADto) throws GeneralException {
        EntityA entityA = new EntityA();
        entityA.setAttributeA(createEntityADto.getAttributeA());
        entityA.setAttributeB(createEntityADto.getAttributeB());

        try{
            entityA = entityARepository.save(entityA);
        } catch (Exception ex){
            throw new InternalServerErrorException("INTERNAL_SERVER_ERROR", "INTERNAL_SERVER_ERROR");
        }


        return modelMapper.map(getEntityAEntity(entityA.getId()),EntityADto.class);
    }

    @Override
    public List<EntityADto> getAllEntityA() throws GeneralException {
        List<EntityA> allEntityA = entityARepository.findAll();
        return allEntityA.stream().map(entityA -> modelMapper.map(entityA, EntityADto.class)).collect(Collectors.toList());
    }

    @Override
    public EntityADto getEntityAById(Long id) throws GeneralException {
        return modelMapper.map(getEntityAEntity(id),EntityADto.class);
    }

    @Override
    public EntityADto updateEntityA(Long id, CreateEntityADto createEntityADto) throws GeneralException {
        EntityA entityA = getEntityAEntity(id);
        entityA.setAttributeA(createEntityADto.getAttributeA());
        entityA.setAttributeB(createEntityADto.getAttributeB());

        try{
            entityA = entityARepository.save(entityA);
        } catch (Exception ex){
            throw new InternalServerErrorException("INTERNAL_SERVER_ERROR", "INTERNAL_SERVER_ERROR");
        }


        return modelMapper.map(getEntityAEntity(entityA.getId()),EntityADto.class) ;
    }

    @Override
    public void deleteEntityA(Long id) throws GeneralException {
        entityARepository.deleteById(id);
    }

    private EntityA getEntityAEntity(Long id) throws GeneralException {
        return entityARepository.findById(id).orElseThrow(() -> new NotFoundException("NOTFOUND-404", "RESTAURANT_NOTFOUND-404"));
    }
}
