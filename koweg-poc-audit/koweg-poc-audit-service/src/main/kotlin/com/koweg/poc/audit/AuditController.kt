package com.koweg.poc.audit

import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class AuditController {

    @PostMapping(value = ["/audits"])
    fun saveAudit(@RequestBody audit: Audit) {
        System.out.println("Receiving " + audit.toString())

    }
}