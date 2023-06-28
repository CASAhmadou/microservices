package com.ecole221.l3dewweb.common.service.events;

import java.util.Date;
import java.util.UUID;

public interface Event {

    UUID getEventId();

    Date getEventDate();
}
