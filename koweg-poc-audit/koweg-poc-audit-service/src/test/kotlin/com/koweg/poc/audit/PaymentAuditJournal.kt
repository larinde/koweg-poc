package com.koweg.poc.audit

enum class PaymentAuditJournal(val code: String, val description: String) {
	PAYMENT_INITIALISED("PAYMENT_INITIALISED", "System has initialised payment process"),
	PAYMENT_SENT("PAYMENT_SENT", "Payment has been been dispatched to processor for completion"),
	PAYMENT_PENDING("PAYMENT_RECEIVED", "Payment processing in progress"),
	PAYMENT_COMPLETION_SUCCESS("PAYMENT_COMPLETION_SUCCESS", "Payment processing completed with failure"),
	PAYMENT_COMPLETION_FAILURE("PAYMENT_COMPLETION_FAILURE", "Payment processing completed with success"),
	UNDEFINED_PAYMENT_AUDIT("UNDEFINED_PAYMENT_AUDIT", "The audit state is either undefined or unknown"),
}