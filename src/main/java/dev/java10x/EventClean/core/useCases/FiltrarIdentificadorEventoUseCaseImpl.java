package dev.java10x.EventClean.core.useCases;

import dev.java10x.EventClean.core.entities.Evento;
import dev.java10x.EventClean.core.exception.NotFoundException;
import dev.java10x.EventClean.core.gateway.EventoGateway;
public class FiltrarIdentificadorEventoUseCaseImpl implements FiltrarIdentificadorEventoUseCase {

    private final EventoGateway eventoGateway;

    public FiltrarIdentificadorEventoUseCaseImpl(EventoGateway eventoGateway) {
        this.eventoGateway = eventoGateway;
    }

    @Override
    public Evento execute(String identificador) {
        return eventoGateway.buscarEventoPorIdentificador(identificador)
                .orElseThrow(() -> new NotFoundException("Evento não encontrado: " + identificador));
    }
}
