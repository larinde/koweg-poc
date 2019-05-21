package com.koweg.poc.audit

import java.util.concurrent.ConcurrentHashMap

object AuditRepository {

    val auditRepository = ConcurrentHashMap<String, AuditData>()


}