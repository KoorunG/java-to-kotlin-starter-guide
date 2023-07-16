package com.lannstark.lec07

import java.io.BufferedReader
import java.io.File
import java.io.FileReader


fun main() {
    // 주어진 문자열을 정수로 변경하는 예제...
//    println(parseIntOrThrowKotlin("3"))
//    println(parseIntOrThrowKotlin("테스트"))

//    println(parseIntOrThrowKotlin2("3"))
//    println(parseIntOrThrowKotlin2("테스트"))

    // 코틀린에서는 모든 예외를 UnChecked Exception으로 처리한다...!!!
    // (매우 편리함)
    KotlinFilePrinter().readFile("a.txt")
    KotlinFilePrinter().readFile("b.txt")
}

fun parseIntOrThrowKotlin(str: String): Int {
    try {
        return str.toInt()
    } catch (e: NumberFormatException) {
        throw IllegalArgumentException("주어진 {$str}은 정수가 아닙니다.")
    }
}

// 코틀린에서는 try-catch 역시 Expression이기 때문에 바로 return할 수 있다..!
fun parseIntOrThrowKotlin2(str: String): Int? {
    return try {
        str.toInt()
    } catch(e: NumberFormatException) {
        null
    }
}