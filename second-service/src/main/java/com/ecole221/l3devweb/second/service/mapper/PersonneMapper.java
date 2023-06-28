package com.ecole221.l3devweb.second.service.mapper;

import com.ecole221.l3devweb.second.service.entity.Personne;
import com.ecole221.l3dewweb.common.service.dto.PersonneDto;
import org.springframework.stereotype.Component;

import java.text.ParseException;

@Component
public class PersonneMapper {

    public Personne personneDtoToPersonneEntity(PersonneDto personneDto) throws ParseException {
        return Personne.builder()
                .id(personneDto.getId())
                .build();
    }

    public PersonneDto personneEntityToPersonneDto(Personne personne) throws ParseException {
        return PersonneDto.builder()
                .id(personne.getId())
                .build();
    }
}
