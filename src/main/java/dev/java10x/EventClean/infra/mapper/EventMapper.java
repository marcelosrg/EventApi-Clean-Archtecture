package dev.java10x.EventClean.infra.mapper;

import dev.java10x.EventClean.core.entities.Evento;
import dev.java10x.EventClean.infra.dtos.EventDto;
import dev.java10x.EventClean.infra.persistence.Entities.EventoEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface EventMapper {
    EventMapper INSTANCE = Mappers.getMapper( EventMapper.class );


    EventoEntity toEntity(Evento evento);
    Evento toDomain(EventoEntity eventoEntity);

    EventDto toDto(Evento evento);

    Evento toDomain(EventDto eventDto);






}
