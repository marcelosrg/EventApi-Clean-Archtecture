package dev.java10x.EventClean.core.useCases;

import dev.java10x.EventClean.core.entities.Evento;

import java.util.UUID;

public interface buscarEventoCase {
    public Evento execute(UUID id);
}
