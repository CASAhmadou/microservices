package com.ecole221.l3dewweb.common.service.events;

import com.ecole221.l3dewweb.common.service.dto.PersonneDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PersonneEvent implements Event {

    private PersonneDto personneDto;

    private PersonneStatus personneStatus;

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
