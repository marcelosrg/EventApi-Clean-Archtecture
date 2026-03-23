package dev.java10x.EventClean.core.useCases;

import dev.java10x.EventClean.core.entities.Evento;

import java.util.Optional;

public interface FiltrarIdentificadorEventoUseCase {
    public Evento execute(String identificador);
}
