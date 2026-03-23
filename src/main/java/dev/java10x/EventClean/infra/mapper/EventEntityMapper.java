package dev.java10x.EventClean.infra.mapper;

import dev.java10x.EventClean.core.entities.Evento;
import dev.java10x.EventClean.infra.dtos.EventDto;
import dev.java10x.EventClean.infra.persistence.EventoEntity;
import org.springframework.stereotype.Component;


@Component
public class EventEntityMapper {
    public Evento toDomain(EventoEntity entity) {
        return new Evento(
                entity.getId(),
                entity.getNome(),
                entity.getDescricao(),
                entity.getIdentificador(),
                entity.getDataInicio(),
                entity.getDataFim(),
                entity.getLocal(),
                entity.getOrganizador(),
                entity.getTipoEvento()
        );
    }

    public EventoEntity toEntity(Evento evento) {
        return new EventoEntity(
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
