package com.ecole221.l3dewweb.common.service.events;

import com.ecole221.l3dewweb.common.service.dto.PersonneAgeDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AgeEvent implements Event{

    private PersonneAgeDto personneAgeDto;

    private AgeStatus ageStatus;

    private UUID eventId = UUID.randomUUID();

    private Date eventDate = new Date();

    public AgeEvent(PersonneAgeDto ageDTO, AgeStatus updated) {

    }

    @Override
    public UUID getEventId() {
        return eventId;
    }

    @Override
    public Date getEventDate() {
        return eventDate;
    }
}
