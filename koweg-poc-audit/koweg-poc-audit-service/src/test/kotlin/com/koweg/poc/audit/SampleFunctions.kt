package com.koweg.poc.audit

//fun sum(x: Int, y: Int) = x + y

fun higherOrder(λ: (Int, Int) -> Int) {
    λ(3,5)
}

fun main(args: Array<String>) {
    higherOrder { x, y -> x + y }
}