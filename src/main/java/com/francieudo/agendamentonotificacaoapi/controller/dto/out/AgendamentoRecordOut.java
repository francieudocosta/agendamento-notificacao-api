package com.francieudo.agendamentonotificacaoapi.controller.dto.out;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.francieudo.agendamentonotificacaoapi.infrastructure.entities.enums.StatusNotificacaoEnum;

import java.time.LocalDateTime;

public record AgendamentoRecordOut(

        Long id,
        String emailDestinario,
        String telefoneDestinario,
        String mensagem,
        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy HH:mm:ss")LocalDateTime dataHoraEnvio,
        StatusNotificacaoEnum statusNotificacao

        ) { }
