package com.ecole221.l3dewweb.common.service.dto;

import com.ecole221.l3dewweb.common.service.events.AgeStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PersonneAgeDto {

    private UUID personneId;
    private long age;

}
