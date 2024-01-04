package com.example.Diagnostico.service.impl;

import com.example.Diagnostico.model.dao.PersonaDao;
import com.example.Diagnostico.model.dto.PersonaDto;
import com.example.Diagnostico.model.entity.PersonaBean;
import com.example.Diagnostico.service.IPersona;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ImplPersona implements IPersona {
    @Autowired
    private PersonaDao personaDao;

    @Override
    @Transactional
    public PersonaBean save(PersonaDto personaDto) {
        PersonaBean persona = PersonaBean.builder()
                .id_persona(personaDto.getId_persona())
                .nombre(personaDto.getNombre())
                .apellido_paterno(personaDto.getApellido_paterno())
                .apellido_materno(personaDto.getApellido_materno())
                .fecha_nacimiento(personaDto.getFecha_nacimiento())
                .curp(personaDto.getCurp()).build();
        return personaDao.save(persona);
    }

    @Override
    @Transactional(readOnly = true)
    public PersonaBean findById(Integer id) {
        return personaDao.findById(id).orElse(null);
    }

    @Override
    @Transactional(readOnly = true)
    public List<PersonaBean> findAll() {
        return (List<PersonaBean>) personaDao.findAll();
    }

    @Override
    @Transactional
    public void delete(PersonaBean personaBean) {
        personaDao.delete(personaBean);
    }
}
