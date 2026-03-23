package dev.java10x.EventClean.infra.presentation;

import dev.java10x.EventClean.core.entities.Evento;
import dev.java10x.EventClean.core.useCases.CriarEventoUseCase;
import dev.java10x.EventClean.infra.dtos.EventDto;
import dev.java10x.EventClean.infra.mapper.EventDtoMapper;
import org.springframework.web.bind.annotation.*;

@RestController()

@RequestMapping("api/v1/event")
public class EventController {

    private final CriarEventoUseCase criarEventoUseCase;
    private final EventDtoMapper eventDtoMapper;


    public EventController(CriarEventoUseCase criarEventoUseCase,
                           EventDtoMapper eventDtoMapper){
        this.criarEventoUseCase = criarEventoUseCase;
        this.eventDtoMapper = eventDtoMapper;
    }

    @PostMapping("create-event")
    public EventDto createEvent(@RequestBody EventDto eventoDto){

        Evento createEvento = criarEventoUseCase.execute(eventDtoMapper.toDomain(eventoDto));

        return eventDtoMapper.toDto(createEvento);
    }

    @GetMapping
    public String getAllEvents(){
        return "Lista de eventos";
    }
}
