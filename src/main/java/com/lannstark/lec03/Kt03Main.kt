package com.lannstark.lec03

fun main() {
    // 1. 코틀린의 타입추론기준 :: 선언된 기본값을 기준으로 타입을 추론함
    val num1 = 0        // Int
    val num2 = 0L       // Long
    val num3 = 0f       // Float

    // 2. 코틀린은 명시적인 타입변경만 가능하다 (근데 지금은 또 잘되는듯...? 버전이 올라가면서 업데이트 됐을수도 있음)
    // 대신 코틀린에서는 toXXX() 와 같은 타입캐스팅 함수를 다양하게 제공한다.
    val number1: Float = 3.1F
    val number2: Int = 5

    println(number2.toFloat() / number1) // 1.6129032
    println(number2 / number1.toInt())   // 1

//    printAgeIfPerson(Person("쿠렁", 30))
//    printAgeIfPerson("에일리언")
    printAgeIfPersonNullable(Person("쿠렁", 30))
    printAgeIfPersonNullable("에일리언")
    printAgeIfPersonNullable(null)

    indexedString("KOORUNG")
    indexedString(null)
}

// 자바 -> 코틀린 변환
// 코틀린의 Any == 자바의 Object 타입
fun printAgeIfPerson(obj: Any) {
    // 코틀린의 is 키워드는 자바의 instanceof 를 대체한다.
    // !is 를 이용하여 not instanceof 와 같은 표현도 가능하다
    if (obj is Person) {
        // 위에서 Type Narrowing을 했기 때문에 생략가능! (타입스크립트와 비슷한듯)
        // as Type으로 타입캐스팅을 할 수 있다.
        // as? 로 null 처리도 가능하다.
//        val person = obj as Person
        println("이름은 $obj.name 이며, 나이는 $obj.age살입니다.")
    }

    if (obj !is Person) {
        println("사람이 아닙니다!!")
    }

}

fun printAgeIfPersonNullable(obj: Any?) {
    if (obj is Person?) {   // Person인 경우와 null인 경우가 처리됨

        // 코틀린의 String 표현식 ::: JSTL과 비슷해서 넘 편안
        println("이름은 ${obj?.name} 이며, 나이는 ${obj?.age}살입니다.")
        return
    }

    // 여기는 Null이 아니면서 Person이 아닌 모든경우가 처리됨
    println("사람이 아닙니다")
}

// 코틀린의 Unit == 자바의 void
// 그러나 코틀린은 void와 다르게 그 자체로 타입인자로 사용 가능하다...!
// 함수형 프로그래밍에서 Unit은 단 하나의 인스턴스만 갖는 타입을 나타남
fun unit(): Unit {

}

// 코틀린의 Nothing == 타입스크립트의 Never (무조건 예외를 반환, 무한루프 등등...)
// 실제로는 잘 사용하지 않음
fun nothing(obj: Any?): Nothing {
    try {
        println("대충 복잡한 로직을 실행함...")
    } catch (e: Exception) {
        println(e.message)
    }
    // Nothing 타입이기 때문에 무조건 예외적인 사항이 명시되어야 컴파일에러가 나지 않음
    throw RuntimeException("")
}

// 코틀린에서 문자열은 파이썬처럼 인덱스로 다룰 수 있다..!!
fun indexedString(str: String?): Unit {
    if (str is String) {
        println(str[0])
        println(str[1])
        println(str[2])
        return
    }
    println("Null")
}
