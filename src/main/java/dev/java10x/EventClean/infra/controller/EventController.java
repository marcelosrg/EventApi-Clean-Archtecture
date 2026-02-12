package dev.java10x.EventClean.infra.controller;

import dev.java10x.EventClean.core.entities.Evento;
import dev.java10x.EventClean.core.useCases.CriarEventoCase;
import dev.java10x.EventClean.infra.dtos.EventDto;
import dev.java10x.EventClean.infra.mapper.EventMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController()

@RequestMapping("api/v1/event")
public class EventController {

    private final CriarEventoCase criarEventoCase;
    private final EventMapper eventMapper;


    public EventController(CriarEventoCase criarEventoCase,
                           EventMapper eventMapper){
        this.criarEventoCase = criarEventoCase;
        this.eventMapper = eventMapper;
    }

    @PostMapping("create-event")
    public ResponseEntity<Map<String, Object>> createEvent(@RequestBody EventDto eventoDto){

        Evento createEvento = criarEventoCase.execute(eventMapper.toDomain(eventoDto));
        Map<String, Object> response = new HashMap<>();
        response.put("Mensagem: ", "Evento cadastrado com sucesso no nosso banco de dados");
        response.put("Dados do evento: ", eventMapper.toDto(createEvento));
        return ResponseEntity.ok(response);
    }
}
