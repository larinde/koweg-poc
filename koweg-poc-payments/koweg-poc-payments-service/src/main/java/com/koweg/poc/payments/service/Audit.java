package com.koweg.poc.payments.service;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Audit {
    private final String auditContext;
    private final LocalDateTime date;
    private final String requestId;
    private final String correlationId;
    private final  String additional;

    public Audit(String auditContext, LocalDateTime date, String requestId, String correlationId, String additional){
        this.auditContext = auditContext;
        this.date = date;
        this.requestId = requestId;
        this.correlationId = correlationId;
        this.additional = additional;
    }

}
