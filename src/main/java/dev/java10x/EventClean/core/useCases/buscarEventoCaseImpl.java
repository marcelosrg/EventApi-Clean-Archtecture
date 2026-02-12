package dev.java10x.EventClean.core.useCases;

import dev.java10x.EventClean.core.entities.Evento;
import dev.java10x.EventClean.core.gateway.EventoGateway;

public class buscarEventoCaseImpl {
    private final EventoGateway eventoGateway;

    public buscarEventoCaseImpl(EventoGateway eventoGateway) {
        this.eventoGateway = eventoGateway;
    }

    @Override
    public Evento execute(Evento evento) {
        if (eventoGateway.existePorIdentificador(evento.identificador())) {
            throw new DuplicateEventException("O identificador numero: " + evento.identificador() + " ja esta em uso para outro evento!");
        }
        return eventoGateway.criarEvento(evento);
    }
}
