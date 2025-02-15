package com.francieudo.agendamentonotificacaoapi.business.mapper;

import com.francieudo.agendamentonotificacaoapi.controller.dto.in.AgendamentoRecord;
import com.francieudo.agendamentonotificacaoapi.controller.dto.out.AgendamentoRecordOut;
import com.francieudo.agendamentonotificacaoapi.infrastructure.entities.Agendamento;
import org.mapstruct.Mapper;

import static org.mapstruct.MappingConstants.ComponentModel.SPRING;

@Mapper(componentModel = SPRING)
public interface IAgendamentoMapper {

    Agendamento paraEntity(AgendamentoRecord agendamentoRecord);

    AgendamentoRecordOut paraOut(Agendamento agendamento);
}
