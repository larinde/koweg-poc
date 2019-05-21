package com.koweg.poc.audit

import java.util.concurrent.ConcurrentHashMap

class AuditServiceImpl : AuditService {

	val auditRepository = ConcurrentHashMap<String, AuditData>()


	//static initialiser block
	companion object {
		val repository = ConcurrentHashMap<String, AuditData>()
	}

	override fun saveAudit(auditData: AuditData) {
		repository.put(auditData.id!!, auditData)
	}

	override fun getAuditByRequestId(requestId: String): AuditData? {
			return repository.get(requestId)
	}


}