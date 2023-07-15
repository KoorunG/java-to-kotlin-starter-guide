package com.lannstark.lec02


fun main() {
//    println(startsWithA1(null))
//    println(startsWithA2(null))
//    println(startsWithA3(null))
//    println(startsWithA1AtKotlin(null))
//    println(startsWithA2AtKotlin(null))
//    println(startsWithA3AtKotlin(null))s

    val person = Person("쿠렁")

    // 코틀린에서 자바코드의 @Nullable, @NotNull 등의 애노테이션을 이해한다...!!
    // 반대로 말하면 위의 정보가 없다면 Nullable 여부를 코틀린이 알 수 없기 때문에 (플랫폼 타입이라고 한다.)
    // NPE가 발생할 수 있다..
    // 따라서 자바 라이브러리를 사용할때는 Nullable 체크를 꼼꼼히 하던가
    // 코틀린으로 래핑하여 사용하는 것이 좋다!
    startsWithA0(person.name)
}

// ********* Lec02Main.java 의 코드를 코틀린 코드로 변환 ********* //

// 코들린에서는 일반 타입과 Nullable 타입이 아예 다른 취급을 받기 때문에
// Nullable인 변수의 null체크를 하지 않으면 컴파일 에러를 던져줌! => null checking이 매우 명확하다..

fun startsWithA0(str: String): Boolean {
    return str.startsWith("A")
}
fun startsWithA1(str: String?): Boolean {
    if(str == null) {
        throw IllegalArgumentException("null이 들어왔습니다.")
    }

    return str.startsWith("A")
}

/**
 * <Safe Call :::: [?.]>
 * null이 가능한 변수에 대해 safe call을 하면 null일 경우 해당 코드를 실행하지 않는다. (즉 null이 리턴됨)
 */
fun startsWithA1AtKotlin(str: String?): Boolean {
    return str?.startsWith("A") ?: throw IllegalArgumentException("null이 들어왔습니다.")
}

fun startsWithA2(str: String?): Boolean? {
    if(str == null) {
        return null
    }

    return str.startsWith("A")
}

/**
 * <Elvis 연산자 :::: [:?]>
 * 앞의 연산결과가 Null이면 뒤의 값을 사용
 * 주로 safe call과 같이 쓰인다
 */
fun startsWithA2AtKotlin(str: String?): Boolean? {
    return str?.startsWith("A")
}

fun startsWithA3(str: String?): Boolean {
    if(str == null) {
        return false
    }
    return str.startsWith("A")
}

fun startsWithA3AtKotlin(str: String?): Boolean {
    return str?.startsWith("A") ?: false
}

// 자바에서 흔히 쓰이는 early return 표현을
// 코틀린에서는 Elvis 연산자를 이용하여 더 간결하게 나타낼 수 있다.
fun earlyReturnAtKotlin(number: Long?) : Long {
    // 1. early return
    number ?: return 0

    // 2. 다음로직...
    return number
}

// Nullable 이지만 논리적으로 절대 null일 수 없는 경우를 단언하려면
// !!. 를 이용하면 된다.
// 이럴경우 null이 혹시나 온다면 런타임에서 NPE가 발생하기 때문에
// 정말 null이 아님이 100% 확실할 경우 사용한다.
fun isNotNullAtKotlin(str: String?): Boolean {
    // 절대 null이 아님을 단언
    return str!!.startsWith("A")
}