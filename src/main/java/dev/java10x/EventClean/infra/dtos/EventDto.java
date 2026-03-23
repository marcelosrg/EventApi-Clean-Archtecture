package dev.java10x.EventClean.infra.dtos;
import dev.java10x.EventClean.core.enums.TipoEvento;
import java.time.LocalDateTime;
import java.util.UUID;

public record EventDto(
        UUID id,
        String nome,
        String descricao,
        String identificador,
        LocalDateTime dataInicio,
        LocalDateTime dataFim,
        String local,
        String organizador,
        TipoEvento tipoEvento
) {}