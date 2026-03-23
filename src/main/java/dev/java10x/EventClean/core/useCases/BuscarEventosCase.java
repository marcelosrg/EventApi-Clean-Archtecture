package dev.java10x.EventClean.core.useCases;

import dev.java10x.EventClean.core.entities.Evento;

import java.util.List;


public interface BuscarEventosCase {
    public List<Evento> execute();
}
