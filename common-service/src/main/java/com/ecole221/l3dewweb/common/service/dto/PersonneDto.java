package com.ecole221.l3dewweb.common.service.dto;


import com.ecole221.l3dewweb.common.service.events.AgeStatus;
import com.ecole221.l3dewweb.common.service.events.PersonneStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PersonneDto {
    private UUID id;
    private String nomComplet;
    private String dateNaissance;
    private PersonneStatus personneStatus;
}
