package com.example.Diagnostico.service;

import com.example.Diagnostico.model.dto.PersonaDto;
import com.example.Diagnostico.model.entity.PersonaBean;

import java.util.List;

public interface IPersona {
    PersonaBean save(PersonaDto personaDto);
    PersonaBean findById(Integer id);
    List<PersonaBean> findAll();
    void delete(PersonaBean personaBean);

}
