package dev.java10x.EventClean.core.gateway;

import dev.java10x.EventClean.core.entities.Evento;

import java.util.List;
import java.util.Optional;

public interface EventoGateway {
    Evento criarEvento(Evento evento);
    List<Evento> listarEventos();

}
