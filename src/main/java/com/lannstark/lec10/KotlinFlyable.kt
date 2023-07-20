package com.lannstark.lec10

interface KotlinFlyable {

    // 코틀린은 "default" 접근제어자가 없어도 기본적으로 메소드를 구현할 수 있다
    fun act() {
        println("파닥 파닥")
    }

    val swimAbility: Int
        get() = 3
}