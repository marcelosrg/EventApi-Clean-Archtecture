package dev.java10x.EventClean.infra.presentation;

import dev.java10x.EventClean.core.entities.Evento;
import dev.java10x.EventClean.core.useCases.BuscarEventosCase;
import dev.java10x.EventClean.core.useCases.CriarEventoUseCase;
import dev.java10x.EventClean.infra.dtos.EventDto;
import dev.java10x.EventClean.infra.mapper.EventDtoMapper;
import dev.java10x.EventClean.infra.mapper.EventEntityMapper;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController()

@RequestMapping("api/v1/event")
public class EventController {

    private final CriarEventoUseCase criarEventoUseCase;
    private final BuscarEventosCase buscarEventosCase;
    private final EventDtoMapper eventDtoMapper;


    public EventController(CriarEventoUseCase criarEventoUseCase,
                           EventDtoMapper eventDtoMapper,
                           BuscarEventosCase buscarEventosCase){
        this.criarEventoUseCase = criarEventoUseCase;
        this.eventDtoMapper = eventDtoMapper;
        this.buscarEventosCase = buscarEventosCase;
    }

    @PostMapping("create-event")
    public EventDto createEvent(@RequestBody EventDto eventoDto){

        Evento createEvento = criarEventoUseCase.execute(eventDtoMapper.toDomain(eventoDto));

        return eventDtoMapper.toDto(createEvento);
    }

    @GetMapping
    public List<EventDto> getAllEvents(){
       List<Evento> eventos = buscarEventosCase.execute();

        return eventos.stream()
                .map(eventDtoMapper::toDto)
                .collect(Collectors.toList());
    }
}
