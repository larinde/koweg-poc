package com.koweg.poc.pymt.gw

interface PaymentProcessor {
	fun process(payment: Payment)
}

enum class PaymentType(val type: String) {
	CARD("card"), CASH("cash"), MOBILE_CARRIER_BILLING("carrierBilling")
}

class VisaCardProcessor : PaymentProcessor {
	override fun process(payment: Payment) {

	}

}


class MasterCardProcessor : PaymentProcessor{
	override fun process(payment: Payment) {

	}
}

class CashProcessor : PaymentProcessor{
	override fun process(payment: Payment) {

	}
}


class MobileCarrierBillingProcessor : PaymentProcessor{
	override fun process(payment: Payment) {

	}
}