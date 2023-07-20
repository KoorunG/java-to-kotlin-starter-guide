package com.lannstark.lec04

fun main() {
    compareMoney(JavaMoney(3000L), JavaMoney(2000L))
    equalsMoney(JavaMoney(3000L), JavaMoney(3000L))
    operatorOverloading(KotlinMoney(3000L), KotlinMoney(3000L))
}

fun compareMoney(money1 : JavaMoney, money2 : JavaMoney) {

    // 코틀린에서 객체를 비교연산자로 호출할 경우 자동으로 compareTo를 호출해준다!!
    when(money1 > money2) {
        true -> println("money1이 money2보다 큽니다.")
        false -> println("money1이 money2보다 작습니다.")
    }
}

fun equalsMoney(money1 : JavaMoney, money2 : JavaMoney) {
    // 코틀린에서 동일성은 == (암묵적으로 equals()를 호출)
    // 동등성은 === 로 비교한다.
    println("코틀린의 == :::: ${money1 == money2}")         // true
    println("코틀린의 === :::: ${money1 === money2}")       // false
}

fun operatorOverloading(money1 : KotlinMoney, money2 : KotlinMoney) {

    /**
     * <KotlinMoney 구현...>
     *
     * data class KotlinMoney(val amount : Long) {
     *     operator fun plus(other : KotlinMoney) : KotlinMoney {
     *         return KotlinMoney(this.amount + other.amount)
     *     }
     * }
     */
    println(money1 + money2)    // KotlinMoney(amount=6000)

    // operator fun ...() 을 이용하여 연산자를 직접 오버로딩하는 것이 가능하다!!
}