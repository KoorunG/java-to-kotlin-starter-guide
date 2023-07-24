package com.lannstark.lec16


fun funcParameter(): Unit = println("Hello World")
fun main() {
    // 코틀린의 함수 래퍼런스 (Java와 비슷한 형태인듯..? 파라미터가 없다면 ::함수명으로 래퍼런스 호출)
    println(3.inlineAdd(4, ::funcParameter))
}

/**
 * inline 함수
 * 함수가 호출되는 대신 함수를 호출한 지점에 함수의 본문을 그대로 복사하고 싶은 경우!!
 * 실제로 바이트코드로 변환된 결과를 보면 로직 자체가 인라인함수를 호출한 곳에 복사된 것을 확인할 수 있다.
 * 함수를 파라미터로 전달할 때 오버헤드를 줄일 수 있다.
 *
 * 보통 파라미터로 함수를 받을 때 사용하면 좋다.. (인텔리제이의 권장사항)
 */
inline fun Int.inlineAdd(other: Int, callback: () -> Unit): Int {
    callback()
    return this + other
}