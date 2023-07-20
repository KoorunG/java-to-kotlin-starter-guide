package com.lannstark.lec04

data class KotlinMoney(val amount : Long) {
    operator fun plus(other : KotlinMoney) : KotlinMoney {
        return KotlinMoney(this.amount + other.amount)
    }
}

