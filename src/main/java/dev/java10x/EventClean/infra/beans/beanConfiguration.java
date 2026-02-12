package dev.java10x.EventClean.infrastructure.beans;
import dev.java10x.EventClean.core.gateway.EventoGateway;
import dev.java10x.EventClean.core.useCases.CriarEventoCase;
import dev.java10x.EventClean.core.useCases.criarEventoCaseImpl;
import dev.java10x.EventClean.core.usecases.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfiguration {

    @Bean
    public CriarEventoCase criarEventoUsecase(EventoGateway eventoGateway) {
        return new criarEventoCaseImpl(eventoGateway);
    }



}