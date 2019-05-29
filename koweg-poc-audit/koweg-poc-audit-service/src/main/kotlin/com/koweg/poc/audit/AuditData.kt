package com.koweg.poc.audit

import java.time.LocalDateTime

//data class that implements java equals && hashcode contracts
data class AuditData (val id: String? = null, val messageId: String, val timeStamp: LocalDateTime, val auditContext: String, var additional: Any){
	
	override fun toString(): String = "id=$id messageId=$messageId timeStamp=$timeStamp auditContext=$auditContext"
	
}