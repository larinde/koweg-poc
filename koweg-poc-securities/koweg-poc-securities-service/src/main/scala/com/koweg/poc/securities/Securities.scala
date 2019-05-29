package com.koweg.poc.securities


import java.time.LocalDateTime

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication

@SpringBootApplication
class Securities

object Application extends App {
  SpringApplication.run(classOf[Securities], args:_*)
}

case class Stock (symbol: String, company: String, unitPrice: BigDecimal, date: LocalDateTime)

case class Position(quantity: BigInt, stock: Stock)