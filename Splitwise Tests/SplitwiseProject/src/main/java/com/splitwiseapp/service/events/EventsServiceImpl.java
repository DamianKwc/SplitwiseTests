package com.splitwiseapp.service.events;

import com.splitwiseapp.dto.eventsDto.EventsDto;
import com.splitwiseapp.entity.EventsEntity;

import com.splitwiseapp.entity.UserEntity;
import com.splitwiseapp.repository.EventsRepository;
import com.splitwiseapp.repository.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.constraints.NotEmpty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EventsServiceImpl implements EventsService {

    private EventsRepository eventsRepository;
    private UserRepository userRepository;

    @Autowired
    public EventsServiceImpl(EventsRepository eventsRepository, UserRepository userRepository) {
        this.eventsRepository = eventsRepository;
        this.userRepository = userRepository;
    }

    @Override
    public List<EventsDto> findAllEvents() {
        List<EventsEntity> events = eventsRepository.findAll();
        return events.stream()
                .map((event) -> mapToEventsDto(event))
                .collect(Collectors.toList());
    }

    @Override
    public void saveEvent(EventsDto eventsDto) {
        EventsEntity event = new EventsEntity();
        event.setEventName(eventsDto.getEventName());
        event.setIdEvent(eventsDto.getIdEvent());
        eventsRepository.save(event);
    }

    private EventsDto mapToEventsDto(EventsEntity event){
        EventsDto eventsDto = new EventsDto();
        eventsDto.setEventName(event.getEventName());

        return eventsDto;
    }
    @Override
    public EventsEntity findByOwner(UserEntity ownerId) {
        return null;
    }

    @Override
    public EventsEntity findByEventName(@NotEmpty String eventName) {
        return  eventsRepository.findByEventName(eventName);
    }

    @Override
    @Transactional
    public EventsDto findById(Integer id) {
        EventsEntity event = eventsRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Event not found by -- ID :" + id));

        EventsDto eventsDto = new EventsDto();
        eventsDto.setIdEvent(event.getIdEvent());
        eventsDto.setEventName(event.getEventName());
        return eventsDto;
    }

    @Override
    public void addUserToEvent(Integer idEvent, Integer idUser) {
        EventsEntity event = eventsRepository.findById(idEvent).
                orElseThrow(() -> new EntityNotFoundException("Event not found by -- ID :" + idEvent));
        UserEntity user = userRepository.findById(idUser).
                orElseThrow(() -> new EntityNotFoundException("User not found by -- ID : " + idUser));
        event.getMembers().add(user);
        eventsRepository.save(event);
    }

}

