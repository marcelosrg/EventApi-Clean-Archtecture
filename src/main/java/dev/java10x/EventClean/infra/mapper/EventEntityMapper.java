package dev.java10x.EventClean.infra.mapper;

import dev.java10x.EventClean.core.entities.Evento;
import dev.java10x.EventClean.infra.dtos.EventDto;
import dev.java10x.EventClean.infra.persistence.EventoEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
@Mapper
public interface EventEntityMapper {
    EventEntityMapper INSTANCE = Mappers.getMapper( EventEntityMapper.class );

    EventoEntity toEntity(Evento evento);
    Evento toDomain(EventoEntity eventoEntity);
}
