package com.koweg.poc.audit

import org.apache.commons.lang.builder.ReflectionToStringBuilder
import org.apache.commons.lang.builder.ToStringStyle
import java.time.LocalDateTime

data class AuditData (val id: String? = null, val auditContext: String, val date: LocalDateTime, val requestId: String, val correlationId: String ){
    override fun toString(): String = ReflectionToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE)
}
