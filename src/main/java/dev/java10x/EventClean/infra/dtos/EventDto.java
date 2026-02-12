package dev.java10x.EventClean.infra.dtos;
import dev.java10x.EventClean.core.enums.TipoEvento;
import java.time.LocalDateTime;

public record EventDto(
        String nome,
        String descricao,
        String identificador,
        LocalDateTime dataInicio,
        LocalDateTime dataFim,
        String local,
        String organizador,
        TipoEvento tipoEvento
) {}