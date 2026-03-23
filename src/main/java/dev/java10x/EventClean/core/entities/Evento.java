package dev.java10x.EventClean.core.entities;

import dev.java10x.EventClean.core.enums.TipoEvento;

import java.time.LocalDateTime;
import java.util.UUID;

public record Evento(
        UUID id,
        String nome,
        String descricao,
        String identificador,
        LocalDateTime dataInicio,
        LocalDateTime dataFim,
        String  local,
        String organizador,
        TipoEvento tipoEvento
) { }
