package com.francieudo.agendamentonotificacaoapi.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.francieudo.agendamentonotificacaoapi.business.AgendamentoService;
import com.francieudo.agendamentonotificacaoapi.controller.dto.in.AgendamentoRecord;
import com.francieudo.agendamentonotificacaoapi.controller.dto.out.AgendamentoRecordOut;
import com.francieudo.agendamentonotificacaoapi.infrastructure.entities.enums.StatusNotificacaoEnum;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.time.LocalDateTime;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(MockitoExtension.class)
public class AgendamentoControllerTest {

    @Mock
    AgendamentoService agendamentoService;

    @InjectMocks
    AgendamentoController agendamentoController;

    private MockMvc mockMvc;

    private ObjectMapper objectMapper = new ObjectMapper();

    private AgendamentoRecord agendamentoRecord;
    private AgendamentoRecordOut agendamentoRecordOut;

    @BeforeEach
    void setUp(){

        mockMvc = MockMvcBuilders.standaloneSetup(agendamentoController).build();

        objectMapper.registerModule(new JavaTimeModule());

        agendamentoRecord = new AgendamentoRecord("fran@gmail.com", "56458879",
                "Ola, cliente", LocalDateTime.of(2025,02,11,01,01));

        agendamentoRecordOut = new AgendamentoRecordOut(1L,"fran@gmail.com", "56458879",
                "Ola, cliente", LocalDateTime.of(2025,02,11,01,01),
                StatusNotificacaoEnum.AGENDADO);
    }


    @Test
    void deveCriarAgendamentoComSucesso() throws Exception {

        when(agendamentoService.gravarAgendamento(agendamentoRecord)).thenReturn(agendamentoRecordOut);

        mockMvc.perform((post("/agendamento")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsBytes(agendamentoRecord))
        )).andExpect(status().isOk()).andExpect(jsonPath("$.id").value(1L))
                .andExpect(jsonPath("$.emailDestinario").value("fran@gmail.com"))
                .andExpect(jsonPath("$.telefoneDestinario").value(agendamentoRecordOut.telefoneDestinario()))
                .andExpect(jsonPath("$.mensagem").value(agendamentoRecordOut.mensagem()))
                .andExpect(jsonPath("$.dataHoraEnvio").value("11-02-2025 01:01:00"))
                .andExpect(jsonPath("$.statusNotificacao").value("AGENDADO"));

        verify(agendamentoService,times(1)).gravarAgendamento(agendamentoRecord);
    }
}
