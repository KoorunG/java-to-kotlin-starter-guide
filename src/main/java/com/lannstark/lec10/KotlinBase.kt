package com.lannstark.lec10


fun main() {
    KotlinDerived(300)
}
open class KotlinBase(
    open val number: Int = 100
) {
    init {
        println(number)
    }
}