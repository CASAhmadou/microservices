package com.ecole221.l3devweb.first.service.service;

import com.ecole221.l3devweb.first.service.entity.Personne;
import com.ecole221.l3devweb.first.service.mapper.PersonneMapper;
import com.ecole221.l3devweb.first.service.repository.PersonneRepository;
import com.ecole221.l3dewweb.common.service.dto.PersonneDto;
import com.ecole221.l3dewweb.common.service.events.AgeEvent;
import com.ecole221.l3dewweb.common.service.events.AgeStatus;
import com.ecole221.l3dewweb.common.service.events.PersonneEvent;
import com.ecole221.l3dewweb.common.service.events.PersonneStatus;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Optional;

@Service
public class PersonneService {
    private static final String personneTopic = "personne-event-topic";
    private final PersonneMapper personneMapper;
    private final PersonneRepository personneRepository;
    private final KafkaTemplate<String, PersonneEvent> kafkaTemplate;

    public PersonneService(PersonneMapper personneMapper, PersonneRepository personneRepository, KafkaTemplate<String, PersonneEvent> kafkaTemplate) {
        this.personneMapper = personneMapper;
        this.personneRepository = personneRepository;
        this.kafkaTemplate = kafkaTemplate;
    }

    public List<PersonneDto> findAll(){
        return personneRepository.findAll().
                stream().map(p-> new PersonneDto(
                        p.getId(), p.getNomComplet(), new SimpleDateFormat("dd/MM/yyyy").format(p.getDateNaissance()),
                        p.getPersonneStatus(), p.getAgeStatus()
                )
        ).toList();
    }

    @Transactional
    public Personne savePersonne(PersonneDto personneDto) throws ParseException {
        personneDto.setPersonneStatus(PersonneStatus.CREATED);
        personneDto.setAgeStatus(AgeStatus.INIT);
        Personne personne = personneRepository.save(personneMapper.personneDtoToPersonneEntity(personneDto));
        personneDto.setId(personne.getId());
        PersonneEvent personneEvent =  new PersonneEvent(personneDto, PersonneStatus.CREATED);
        //send to kafka for update age
        kafkaTemplate.send(personneTopic, personneEvent);
        return personne;
    }

    @Transactional
    public void updatePersonne(AgeEvent ageEvent) {
        Optional<Personne> personne = personneRepository.findById(ageEvent.getPersonneAgeDto().getPersonneId());
        if(!personne.isEmpty()){
            boolean isAgeSaved = AgeStatus.UPDATED.equals(ageEvent.getAgeStatus());
            PersonneStatus personneStatus = isAgeSaved?PersonneStatus.COMPLETED:PersonneStatus.ERROR_AGE;
            personne.get().setPersonneStatus(personneStatus);
            personne.get().setAgeStatus(AgeStatus.UPDATED);
            if(!isAgeSaved){
                personne.get().setAgeStatus(AgeStatus.ERROR_AGE);
            }
        }
    }

}