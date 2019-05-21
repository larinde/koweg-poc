package com.koweg.poc.audit

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.runner.RunWith
import org.springframework.test.context.junit4.SpringRunner
import java.time.Instant
import java.time.LocalDateTime
import java.time.ZoneId


@RunWith(SpringRunner::class)
class AuditServiceImplTest {
	
	val auditService = AuditServiceImpl( )
	
	@Test
	fun shouldSaveAuditData(){
		val auditData = AuditData("id", "corrId", LocalDateTime.ofInstant(Instant.now(), ZoneId.of("UTC")), PaymentAuditJournal.PAYMENT_INITIALISED.name, "")
		auditService.saveAudit(auditData)
		val result = auditService.getAuditByRequestId("id")
		assertThat(result).isNotNull
		System.out.println(result)
		System.out.println(PaymentAuditJournal.valueOf(result?.auditContext ?: PaymentAuditJournal.UNDEFINED_PAYMENT_AUDIT.name).description)
		
	}
}