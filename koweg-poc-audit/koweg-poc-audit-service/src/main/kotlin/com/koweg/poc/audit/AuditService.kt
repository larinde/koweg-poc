package com.koweg.poc.audit

import java.util.Optional

interface AuditService {
	fun saveAudit(auditData: Audit)
	fun getAuditByRequestId(requestId: String): Audit?
}