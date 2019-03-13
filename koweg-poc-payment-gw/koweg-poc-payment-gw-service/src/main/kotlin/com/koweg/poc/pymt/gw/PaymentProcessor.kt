package com.koweg.poc.pymt.gw

interface PaymentProcessor {
	fun process(payment: Payment)
}