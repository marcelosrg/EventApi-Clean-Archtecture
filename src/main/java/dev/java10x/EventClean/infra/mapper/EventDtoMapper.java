package dev.java10x.EventClean.infra.mapper;

import dev.java10x.EventClean.core.entities.Evento;
import dev.java10x.EventClean.infra.dtos.EventDto;
import org.springframework.stereotype.Component;

@Component
public class EventDtoMapper {

    public Evento toDomain(EventDto dto) {
        return new Evento(
                dto.id(),
                dto.nome(),
                dto.descricao(),
                dto.identificador(),
                dto.dataInicio(),
                dto.dataFim(),
                dto.local(),
                dto.organizador(),
                dto.tipoEvento()
        );
    }

    public EventDto toDto(Evento evento) {
        return new EventDto(
                evento.id(),
                evento.nome(),
                evento.descricao(),
                evento.identificador(),
                evento.dataInicio(),
                evento.dataFim(),
                evento.local(),
                evento.organizador(),
                evento.tipoEvento()
        );
    }
}