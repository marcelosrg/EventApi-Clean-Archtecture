package dev.java10x.EventClean.infra.persistence;

import dev.java10x.EventClean.core.enums.TipoEvento;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "EVENTOS")

public class EventoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private UUID id;

    @Column(name = "NOME")
    private String nome;

    @Column(name = "DESCRICAO")
    private String descricao;

    @Column(name = "IDENTIFICADOR")
    private String identificador;

    @Column(name = "DATAINICIO")
    private LocalDateTime dataInicio;

    @Column(name = "DATAFIM")
    private LocalDateTime dataFim;

    @Column(name = "LOCAL")
    private String  local;

    @Column(name = "ORGANIZADOR")
    private String organizador;

    @Column(name = "TIPO")
    private TipoEvento tipo;
}
