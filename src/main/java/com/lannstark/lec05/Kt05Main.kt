package com.lannstark.lec05

fun main() {
//    validateScoreIsNotNegative(70)
//    validateScoreIsNotNegative(-30)

//    println(getPassOrFail(40))
//    println(getPassOrFail(60))

//    println(getGrade(90))
//    println(getGrade(80))
//    println(getGrade(70))
//    println(getGrade(40))

//    println(getGradeWithSwitch(90))
//    println(getGradeWithSwitch(80))
//    println(getGradeWithSwitch(70))
//    println(getGradeWithSwitch(40))

//    judgeNumber(-2)
//    judgeNumber(-1)
//    judgeNumber(-0)
//    judgeNumber(-1)
//    judgeNumber(2)

    judgeNumber2(0)
    judgeNumber2(1)
    judgeNumber2(2)
}

fun validateScoreIsNotNegative(score: Int) {
//    if (score < 0) throw IllegalArgumentException("$score 는 0보다 작을 수 없습니다.")

    // 코틀린에서는 위의 표현을 in을 이용하여 이런식으로 표현하는 것이 가능하다!
    if (score !in 0..100) throw IllegalArgumentException("$score 는 0보다 작을 수 없습니다.")
    println("$score 점입니다.")
}

fun getPassOrFail(score: Int): String {
    // 코틀린에서는 if else 문이 Expression이기 때문에 하나의 값으로 결과가 도출되어 리턴이 가능하다!!
    // (자바의 삼항연산자와 비슷...)
    return if (score >= 50) "P" else "F"
}

fun getGrade(score: Int): String {
    // 코틀린에서는 if else 문이 Expression이기 때문에 하나의 값으로 결과가 도출되어 리턴이 가능하다!!
    // (자바의 삼항연산자와 비슷...)
    return if (score >= 90) "A" else if (score >= 80) "B" else if (score >= 70) "C" else "D"
}

fun getGradeWithSwitch(score : Int) : String {
    // 자바의 switch case 문은
    // 코틀린에서 when -> 으로 바뀌었으며
    // 역시 Expression이기 때문에 하나의 결과로 도출되어 리턴 가능하다!
    return when(score) {
        in 90..99 -> "A"
        in 80..89 -> "B"
        in 70..79 -> "C"
        else -> "D"
    }
}

fun startsWithA(obj : Any) : Boolean {
    return when (obj) {
        is String -> obj.startsWith("A")
        else -> false
    }
}

fun judgeNumber(number : Int) {
    when(number) {
        -1, 0, 1 -> println("어디서 많이 본 숫자입니다.")
        else -> println("처음본 숫자네요.")
    }
}

// when 역시 Expression이기 때문에 이런식으로 {} 없이 바로 = 으로 리턴하는 것이 가능하다. (Unit 타입의 존재때문에 이런식으로 가능)
fun judgeNumber2(number : Int) = when {
    number == 0 -> println("주어진 숫자는 0입니다.")
    number % 2 == 0 -> println("주어진 숫자는 짝수입니다.")
    else -> println("주어진 숫자는 홀수입니다.")
}