package com.lannstark.lec06

// 코틀린의 반복문을 다루는 방법
fun main() {
    // 1. for-each
    kotlinForEach()

    // 2. for (Proigression, Range)
    kotlinFor()

    // 3. while
    kotlinWhile()
}

fun kotlinFor() {
    // 1부터 3까지
//    for(i in 1..3) {
//        println("for :::: $i")
//    }

//    // 3부터 1까지
//    for(i in 3 downTo 1) {
//        println("for :::: $i")
//    }

//    // 2씩 올라갈때
//    for(i in 1..6 step 2) {
//        println("for :::: $i")
//    }

    // 9부터 1까지 3씩 내려갈때
    for(i in 9 downTo 1 step 3) {
        println("for :::: $i")
    }

    /**
     * 코틀린에서는 infix 함수라는 것을 선언할 수 있기 때문에
     * downTo, step 등이 infix 함수로 선언되어 있어 이렇게 표현하는 것이 가능하다!!
     */
}

fun kotlinForEach() {
    val numbers = listOf(1L, 2L, 3L)
    for(number in numbers) {    // 자바의 for-each 에서 콜론 대신 in 연산자를 쓴다.
        println("forEach :::: $number")
    }
}

fun kotlinWhile() {
    var i = 1
    while (i <= 3) {
        println("while :::: $i")
        i++
    }
}