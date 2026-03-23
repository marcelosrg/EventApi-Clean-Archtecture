package dev.java10x.EventClean.infra.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface EventRepository extends JpaRepository<EventoEntity, UUID> {
    public Optional<EventoEntity> findEventoEnityByIdentificador(String identificador);
}
