package com.ecole221.l3devweb.second.service.service;

import com.ecole221.l3devweb.second.service.entity.Personne;
import com.ecole221.l3devweb.second.service.mapper.PersonneMapper;
import com.ecole221.l3devweb.second.service.repository.PersonneRepository;
import com.ecole221.l3dewweb.common.service.dto.PersonneDto;
import com.ecole221.l3dewweb.common.service.events.PersonneStatus;

import java.text.ParseException;
import java.util.List;

public class PersonneService {

    private final PersonneRepository personneRepository;

    private final PersonneMapper personneMapper;

    public PersonneService(PersonneRepository personneRepository, PersonneMapper personneMapper) {
        this.personneRepository = personneRepository;
        this.personneMapper = personneMapper;
    }

    public Personne save(PersonneDto personneDto) throws ParseException{
        personneDto.setPersonneStatus(PersonneStatus.CREATED);

        return personneRepository.save(personneMapper.personneDtoToPersonneEntity(personneDto));
    }

    public List<PersonneDto> allPersonnes(){
        return personneRepository.findAll().stream()
                .map(personne -> new PersonneDto()).toList();
    }
}
