package com.example.controllers;

import com.example.dtos.CreateEntityADto;
import com.example.dtos.EntityADto;
import com.example.exceptions.GeneralException;
import com.example.responses.GeneralResponse;
import com.example.services.EntityAService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/base" + "/v1")
public class EntityAController {

    @Autowired
    private EntityAService entityAService;

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/entitya/{id}")
    public GeneralResponse<EntityADto> getEntityAById(@PathVariable Long id) throws GeneralException {
        return new GeneralResponse<>("Success", String.valueOf(HttpStatus.OK), "OK",
                entityAService.getEntityAById(id));
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/entitya")
    public GeneralResponse<List<EntityADto>> getAllEntityA() throws GeneralException {
        return new GeneralResponse<>("Success", String.valueOf(HttpStatus.OK), "OK",
                entityAService.getAllEntityA());
    }

    @ResponseStatus(HttpStatus.OK)
    @PostMapping("/entitya")
    public GeneralResponse<EntityADto> createEntityA(@RequestBody CreateEntityADto createEntityADto) throws GeneralException {
        return new GeneralResponse<>("Success", String.valueOf(HttpStatus.OK), "OK",
                entityAService.createEntityA(createEntityADto));
    }

    @ResponseStatus(HttpStatus.OK)
    @PutMapping("/entitya/{id}")
    public GeneralResponse<EntityADto> updateEntityA(@PathVariable Long id, @RequestBody CreateEntityADto createEntityADto) throws GeneralException {
        return new GeneralResponse<>("Success", String.valueOf(HttpStatus.OK), "OK",
                entityAService.updateEntityA(id, createEntityADto));
    }

    @ResponseStatus(HttpStatus.OK)
    @DeleteMapping("/entitya/{id}")
    public GeneralResponse<String> deleteEntityA(@PathVariable Long id) throws GeneralException {
        entityAService.deleteEntityA(id);
        return new GeneralResponse<>("Success", String.valueOf(HttpStatus.OK), "OK",
                "Delete OK");
    }
}
