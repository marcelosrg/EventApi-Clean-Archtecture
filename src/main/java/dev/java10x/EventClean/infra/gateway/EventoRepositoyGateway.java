package dev.java10x.EventClean.infra.gateway;

import dev.java10x.EventClean.core.entities.Evento;
import dev.java10x.EventClean.core.gateway.EventoGateway;
import dev.java10x.EventClean.infra.mapper.EventEntityMapper;
import dev.java10x.EventClean.infra.persistence.EventoEntity;
import dev.java10x.EventClean.infra.persistence.EventRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class EventoRepositoyGateway implements EventoGateway {

    private final EventRepository eventRepository;

    private final EventEntityMapper eventEntityMapper;
    public EventoRepositoyGateway(EventRepository eventRepository,
                                  EventEntityMapper eventEntityMapper) {
        this.eventRepository = eventRepository;
        this.eventEntityMapper = eventEntityMapper;
    }

    @Override
    public Evento criarEvento(Evento evento){
        EventoEntity entity = eventEntityMapper.toEntity(evento);
        EventoEntity createEvent = eventRepository.save(entity);
        return  eventEntityMapper.toDomain(createEvent);
    }

    @Override
    public List<Evento> listarEventos() {
        List<EventoEntity> events = eventRepository.findAll();
        return events.stream()
                .map(eventEntityMapper::toDomain)
                .collect(Collectors.toList());
    }
}
