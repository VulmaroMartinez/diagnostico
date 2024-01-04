package com.example.Diagnostico.controller;

import com.example.Diagnostico.model.dto.PersonaDto;
import com.example.Diagnostico.model.entity.PersonaBean;
import com.example.Diagnostico.service.IPersona;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/persona")
public class personaController {
    @Autowired
    private IPersona personaService;

    @GetMapping("/")
    public List<PersonaBean> getPersonas() {
        return personaService.findAll();
    }

    @GetMapping("/{id}")
    public PersonaBean showById(@PathVariable Integer id) {
        return personaService.findById(id);
    }

    @PostMapping("/")
    public PersonaDto create(@RequestBody PersonaDto personaDto) {
        PersonaBean personaSave = personaService.save(personaDto);
        return PersonaDto.builder()
                .id_persona(personaSave.getId_persona())
                .nombre(personaSave.getNombre())
                .apellido_paterno(personaSave.getApellido_paterno())
                .apellido_materno(personaSave.getApellido_materno())
                .fecha_nacimiento(personaSave.getFecha_nacimiento())
                .curp(personaSave.getCurp())
                .build();
    }

    @PutMapping("/")
    public PersonaDto update(@RequestBody PersonaDto personaDto) {
        PersonaBean personaUpdate = personaService.save(personaDto);
        return PersonaDto.builder()
                .id_persona(personaUpdate.getId_persona())
                .nombre(personaUpdate.getNombre())
                .apellido_paterno(personaUpdate.getApellido_paterno())
                .apellido_materno(personaUpdate.getApellido_materno())
                .fecha_nacimiento(personaUpdate.getFecha_nacimiento())
                .curp(personaUpdate.getCurp())
                .build();
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        PersonaBean persona = personaService.findById(id);
        personaService.delete(persona);
    }

}
