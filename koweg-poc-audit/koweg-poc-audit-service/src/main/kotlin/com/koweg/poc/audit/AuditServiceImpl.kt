package com.koweg.poc.audit

import java.util.concurrent.ConcurrentHashMap
import java.util.Optional

class AuditServiceImpl : AuditService {

	val auditRepository = ConcurrentHashMap<String, Audit>()


	//static initialiser block
	companion object {
		val repository = ConcurrentHashMap<String, Audit>()
	}

	override fun saveAudit(auditData: Audit) {
		repository.put(auditData.id!!, auditData)
	}

	override fun getAuditByRequestId(requestId: String): Audit? {
			return repository.get(requestId)
	}


}