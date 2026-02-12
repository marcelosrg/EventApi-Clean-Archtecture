package dev.java10x.EventClean.infra.gateway;

import dev.java10x.EventClean.core.entities.Evento;
import dev.java10x.EventClean.core.gateway.EventoGateway;
import dev.java10x.EventClean.infra.mapper.EventMapper;
import dev.java10x.EventClean.infra.persistence.Entities.EventoEntity;
import dev.java10x.EventClean.infra.persistence.Repositoy.EventRepository;

public class EventoRepositoyGateway implements EventoGateway {

    private final EventRepository eventRepository;
    private final EventMapper eventMapper;
    public EventoRepositoyGateway(EventRepository eventRepository,
                                  EventMapper eventMapper){
        this.eventRepository = eventRepository;
        this.eventMapper = eventMapper;
    }

    @Override
    public Evento criarEvento(Evento evento){
        EventoEntity entity = eventMapper.toEntity(evento);
        EventoEntity createEvent = eventRepository.save(entity);
        return  eventMapper.toDomain(createEvent);
    }
}
