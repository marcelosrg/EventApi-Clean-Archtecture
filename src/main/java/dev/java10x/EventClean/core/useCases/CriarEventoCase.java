package dev.java10x.EventClean.core.useCases;

import dev.java10x.EventClean.core.entities.Evento;

public interface CriarEventoCase {

    public Evento execute(Evento event);
}
