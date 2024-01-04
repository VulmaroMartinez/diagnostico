package com.example.Diagnostico.model.dao;

import com.example.Diagnostico.model.entity.PersonaBean;
import org.springframework.data.repository.CrudRepository;

public interface PersonaDao extends CrudRepository<PersonaBean, Integer> {
}
