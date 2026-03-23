package dev.java10x.EventClean.core.useCases;

import dev.java10x.EventClean.core.entities.Evento;
import dev.java10x.EventClean.core.gateway.EventoGateway;

public class CriarEventoUseCaseImpl implements CriarEventoUseCase {


    private final EventoGateway eventGateway;

    public CriarEventoUseCaseImpl(EventoGateway eventGateway) {
        this.eventGateway = eventGateway;
    }
    @Override
    public Evento execute(Evento event) {
        return eventGateway.criarEvento(event);
    }
}
