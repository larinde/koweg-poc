package com.koweg.poc.audit

interface AuditService {
	fun saveAudit(auditData: AuditData)
	fun getAuditByRequestId(requestId: String): AuditData?
}