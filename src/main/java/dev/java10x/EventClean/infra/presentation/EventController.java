package dev.java10x.EventClean.infra.presentation;
import dev.java10x.EventClean.core.entities.Evento;
import dev.java10x.EventClean.core.useCases.BuscarEventosCase;
import dev.java10x.EventClean.core.useCases.CriarEventoUseCase;
import dev.java10x.EventClean.core.useCases.FiltrarIdentificadorEventoUseCase;
import dev.java10x.EventClean.infra.dtos.EventDto;
import dev.java10x.EventClean.infra.mapper.EventDtoMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController()

@RequestMapping("api/v1/event")
public class EventController {

    private final CriarEventoUseCase criarEventoUseCase;
    private final BuscarEventosCase buscarEventosCase;
    private final FiltrarIdentificadorEventoUseCase filtrarEventoUseCase;
    private final EventDtoMapper eventDtoMapper;


    public EventController(CriarEventoUseCase criarEventoUseCase,
                           EventDtoMapper eventDtoMapper,
                           BuscarEventosCase buscarEventosCase,
                           FiltrarIdentificadorEventoUseCase filtrarEventoUseCase
                           ){
        this.criarEventoUseCase = criarEventoUseCase;
        this.eventDtoMapper = eventDtoMapper;
        this.buscarEventosCase = buscarEventosCase;
        this.filtrarEventoUseCase = filtrarEventoUseCase;
    }

    @PostMapping("create-event")
    public ResponseEntity<EventDto> createEvent(@RequestBody EventDto eventoDto) {

        Evento created = criarEventoUseCase.execute(eventDtoMapper.toDomain(eventoDto));
        EventDto responseDto = eventDtoMapper.toDto(created);

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(created.id())
                .toUri();

        return ResponseEntity.created(location).body(responseDto);
    }

    @GetMapping
    public List<EventDto> getAllEvents(){
       List<Evento> eventos = buscarEventosCase.execute();
        return eventos.stream()
                .map(eventDtoMapper::toDto)
                .collect(Collectors.toList());
    }

    @GetMapping("/{identificador}")
    public EventDto getEventByIdentificador(@PathVariable String identificador){
        return eventDtoMapper.toDto(filtrarEventoUseCase.execute(identificador));
    }
}
