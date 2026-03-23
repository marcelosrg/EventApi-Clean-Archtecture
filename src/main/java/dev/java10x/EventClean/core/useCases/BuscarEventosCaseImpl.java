package dev.java10x.EventClean.core.useCases;

import dev.java10x.EventClean.core.entities.Evento;
import dev.java10x.EventClean.core.gateway.EventoGateway;

import java.util.List;

public class BuscarEventosCaseImpl implements BuscarEventosCase {
    private final EventoGateway eventoGateway;

    public BuscarEventosCaseImpl(EventoGateway eventoGateway) {
        this.eventoGateway = eventoGateway;
    }

    @Override
    public List<Evento> execute() {
        return eventoGateway.listarEventos();
    }
}
