package com.francieudo.agendamentonotificacaoapi.infrastructure.repositories;

import com.francieudo.agendamentonotificacaoapi.infrastructure.entities.Agendamento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AgendamentoRepository extends JpaRepository<Agendamento, Long> {
}
