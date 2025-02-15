package com.francieudo.agendamentonotificacaoapi.infrastructure.exception;

public class NotFoundException extends RuntimeException{

    public NotFoundException(String mensage){

        super(mensage);
    }
}
