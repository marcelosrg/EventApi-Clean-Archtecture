package dev.java10x.EventClean.infrastructure.beans;
import dev.java10x.EventClean.core.gateway.EventoGateway;
import dev.java10x.EventClean.core.useCases.CriarEventoUseCase;
import dev.java10x.EventClean.core.useCases.CriarEventoUseCaseImpl;
import dev.java10x.EventClean.core.usecases.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfiguration {

    @Bean
    public CriarEventoUseCase criarEventoUsecase(EventoGateway eventoGateway) {
        return new CriarEventoUseCaseImpl(eventoGateway);
    }



}