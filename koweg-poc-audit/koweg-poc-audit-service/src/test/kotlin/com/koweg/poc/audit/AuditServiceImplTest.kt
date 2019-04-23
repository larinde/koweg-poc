package com.koweg.poc.audit

import org.junit.runner.RunWith
import org.springframework.test.context.junit4.SpringRunner
//import org.junit.Test
import java.time.LocalTime
import java.time.ZonedDateTime
import java.time.LocalDateTime
import java.time.ZoneId
import java.time.Instant

import org.assertj.core.api.Assertions.assertThat
//import org.junit.jupiter.api.Test
import org.assertj.core.api.Assertions.*
import org.junit.jupiter.api.AfterAll
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.Test


@RunWith(SpringRunner::class)
class AuditServiceImplTest {
	
	val auditService = AuditServiceImpl( )
	
	@Test
	fun shouldSaveAuditData(){
		val auditData = Audit("id", "corrId", LocalDateTime.ofInstant(Instant.now(), ZoneId.of("UTC")), PaymentAuditJournal.PAYMENT_INITIALISED.name, "")
		auditService.saveAudit(auditData)
		val result = auditService.getAuditByRequestId("id")
		assertThat(result).isNotNull
		System.out.println(result)
		System.out.println(PaymentAuditJournal.valueOf(result?.auditContext ?: PaymentAuditJournal.UNDEFINED_PAYMENT_AUDIT.name).description)
		
	}
}