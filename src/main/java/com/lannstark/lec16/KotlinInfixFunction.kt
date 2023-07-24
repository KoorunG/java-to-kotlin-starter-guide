package com.lannstark.lec16

fun main() {
    println(3 infixAdd 4)
}

// Infix 함수 (중위호출)
// 수신객체 함수 파라미터 와 같은 형태로 선언 가능한 함수
private infix fun Int.infixAdd(other: Int): Int = this + other