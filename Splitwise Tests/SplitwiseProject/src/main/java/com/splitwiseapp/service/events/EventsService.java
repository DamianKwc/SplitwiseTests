package com.splitwiseapp.service.events;

import com.splitwiseapp.dto.eventsDto.EventsDto;
import com.splitwiseapp.dto.userDto.UserDto;
import com.splitwiseapp.entity.EventsEntity;
import com.splitwiseapp.entity.UserEntity;
import jakarta.validation.constraints.NotEmpty;
import org.springframework.data.relational.core.sql.In;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface EventsService {
    List<EventsDto> findAllEvents();

    void saveEvent(EventsDto eventsDto);

    EventsEntity findByOwner(UserEntity ownerId);

    EventsEntity findByEventName(@NotEmpty String eventName);

    EventsDto findById(Integer id);

    void addUserToEvent(Integer idEvent, Integer idUser);
}
