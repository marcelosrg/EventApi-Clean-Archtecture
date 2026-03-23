package dev.java10x.EventClean.infra.mapper;

import dev.java10x.EventClean.core.entities.Evento;
import dev.java10x.EventClean.infra.dtos.EventDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface EventDtoMapper {
    EventDtoMapper INSTANCE = Mappers.getMapper( EventDtoMapper.class );

    Evento toDomain(EventDto eventDto);
    EventDto toDto(Evento evento);


}
