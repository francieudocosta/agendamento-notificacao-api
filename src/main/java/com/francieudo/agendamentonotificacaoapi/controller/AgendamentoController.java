package com.francieudo.agendamentonotificacaoapi.controller;

import com.francieudo.agendamentonotificacaoapi.business.AgendamentoService;
import com.francieudo.agendamentonotificacaoapi.controller.dto.in.AgendamentoRecord;
import com.francieudo.agendamentonotificacaoapi.controller.dto.out.AgendamentoRecordOut;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/agendamento")
public class AgendamentoController {

    private final AgendamentoService agendamentoService;

    @PostMapping
    public ResponseEntity<AgendamentoRecordOut> gravarAgendamentos(@RequestBody AgendamentoRecord agendamentoRecord){

        return  ResponseEntity.ok(agendamentoService.gravarAgendamento(agendamentoRecord));
    }

    @GetMapping("/{id}")
    public ResponseEntity<AgendamentoRecordOut> buscarAgendamentoPorId(@PathVariable Long id){

        return ResponseEntity.ok(agendamentoService.buscarAgendamentoPorId(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> cancelarAgendamento(@PathVariable Long id){

        agendamentoService.cancelarAgendamento(id);

        return ResponseEntity.accepted().build();
    }
}
