package com.ecole221.l3dewweb.common.service.events;

import com.ecole221.l3dewweb.common.service.dto.PersonneAgeDto;

import java.util.Date;
import java.util.UUID;

public class AgeEvent implements Event{

    private PersonneAgeDto personneAgeDto;

    private AgeStatus ageStatus;

    private UUID eventId = UUID.randomUUID();

    private Date eventDate = new Date();

    @Override
    public UUID getEventId() {
        return eventId;
    }

    @Override
    public Date getEventDate() {
        return eventDate;
    }
}
