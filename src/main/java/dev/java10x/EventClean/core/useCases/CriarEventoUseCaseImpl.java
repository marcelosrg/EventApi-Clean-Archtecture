package dev.java10x.EventClean.core.useCases;

import dev.java10x.EventClean.core.entities.Evento;
import dev.java10x.EventClean.core.exception.DuplicateException;
import dev.java10x.EventClean.core.gateway.EventoGateway;

public class CriarEventoUseCaseImpl implements CriarEventoUseCase {


    private final EventoGateway eventGateway;

    public CriarEventoUseCaseImpl(EventoGateway eventGateway) {
        this.eventGateway = eventGateway;
    }


    @Override
    public Evento execute(Evento event) {

        eventGateway.buscarEventoPorIdentificador(event.identificador());

        if (eventGateway.buscarEventoPorIdentificador(event.identificador()).isPresent()){
            throw  new DuplicateException("Já existe um evento com o identificador: " + event.identificador());
        }
        return eventGateway.criarEvento(event);
    }
}
