package com.lannstark.lec01

/**
 * 코틀린의 실행함수는 fun main() 으로 선언하며 클래스안에서 만들필요가 없다.
 * 코틀린은 접근제어자를 별도로 지시하지 않으면 public이다.
 */
fun main() {

    // var = 변동가능, val = 불변
    // 타입스크립트처럼 타입을 지정할 수 있다.
    var number1: Long = 10L;
    val number2: Long = 10L;

    var number3: Int    // var은 초기값을 지정하지 않는 경우 타입을 반드시 선언해줘야하고
    var nubmer4 = 3     // 타입을 선언하지 않을 경우에는 초기화가 되어야 한다.

    println(number1)
    println(number2)

    /** 모든 변수는 우선 val로 만들고 필요한 경우 var로 만들어 사용하는 것을 추천한다. */

    // 코틀린에서는 Boxing과 UnBoxing을 자동으로 처리해준다..!
    var n1 = 10L
    val n2 = 10L
    var n3 = 1_000L

    // 코틀린에서는 기본적으로 변수는 Not Null이다
    // Nullable 변수를 선언할 경우 타입 옆에 ?를 붙인다.
    var n4: Long? = 10_000L
    n4 = null

    // 코틀린에서는 객체의 인스턴스를 만들 때 new를 사용하지 않는다.
    var person = Person("이재학")
}