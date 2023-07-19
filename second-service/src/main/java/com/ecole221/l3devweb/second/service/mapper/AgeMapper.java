package com.ecole221.l3devweb.second.service.mapper;

import com.ecole221.l3devweb.second.service.entity.AgeEntity;
import com.ecole221.l3dewweb.common.service.dto.PersonneAgeDto;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Component;

@Component
public class AgeMapper {

    public PersonneAgeDto AgeEntityToAgeDto(AgeEntity ageEntity){
        return PersonneAgeDto.builder()
                .personneId(ageEntity.getPersonneId())
                .age(ageEntity.getAge())
                .build();
    }
}