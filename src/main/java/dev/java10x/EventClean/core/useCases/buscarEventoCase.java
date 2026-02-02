package dev.java10x.EventClean.core.useCases;

import dev.java10x.EventClean.core.entities.Event;

import java.util.UUID;

public interface buscarEventoCase {
    public Event execute(UUID id);
}
