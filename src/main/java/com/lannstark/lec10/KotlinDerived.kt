package com.lannstark.lec10

class KotlinDerived(
    override val number: Int
): KotlinBase(number) {
    init {
        println("Derived Class")
    }
}