package dev.java10x.EventClean.infra.persistence.Repositoy;

import dev.java10x.EventClean.infra.persistence.Entities.EventoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface EventRepository extends JpaRepository<EventoEntity, UUID> {
}
