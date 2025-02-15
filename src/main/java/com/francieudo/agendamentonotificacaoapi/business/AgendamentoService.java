package com.francieudo.agendamentonotificacaoapi.business;

import com.francieudo.agendamentonotificacaoapi.business.mapper.IAgendamentoMapper;
import com.francieudo.agendamentonotificacaoapi.controller.dto.in.AgendamentoRecord;
import com.francieudo.agendamentonotificacaoapi.controller.dto.out.AgendamentoRecordOut;
import com.francieudo.agendamentonotificacaoapi.infrastructure.repositories.AgendamentoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class AgendamentoService {

    private final AgendamentoRepository repository;

    private final IAgendamentoMapper agendamentoMapper;

    public AgendamentoRecordOut gravarAgendamento(AgendamentoRecord agendamentoRecord){

        return agendamentoMapper.paraOut(
                repository.save(agendamentoMapper.paraEntity(agendamentoRecord))
        );
    }
}
