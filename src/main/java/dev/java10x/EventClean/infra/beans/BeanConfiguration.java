package dev.java10x.EventClean.infra.beans;
import dev.java10x.EventClean.core.gateway.EventoGateway;
import dev.java10x.EventClean.core.useCases.*;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfiguration {

    @Bean
    public CriarEventoUseCase criarEventoUseCase(EventoGateway eventoGateway) {
        return new CriarEventoUseCaseImpl(eventoGateway);
    }

    @Bean
    public BuscarEventosCase buscarEventoUseCase(EventoGateway eventoGateway) {
        return new BuscarEventosCaseImpl(eventoGateway);
    }

    @Bean
    public FiltrarIdentificadorEventoUseCase filtrarIdentificadorEventoUseCase(EventoGateway eventoGateway) {
        return new FiltrarIdentificadorEventoUseCaseImpl(eventoGateway);
    }
}