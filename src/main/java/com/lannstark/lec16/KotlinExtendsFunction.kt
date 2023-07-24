package com.lannstark.lec16


fun main() {
//    println("Koorung의 마지막 문자 :::: ${"Koorung".lastChar()}")

    val ko = Human("쿠렁", 30)
    println(ko.nextYearAge())   // 시그니쳐가 같은 경우 멤버함수가 호출되는 것을 확인할 수 있다..! 주의할 것

    val train: Train = Train()
    val srtInTrain: Train = Srt()
    val srt: Srt = Srt()

    train.isExpensive()         // Train의 확장함수임
    srtInTrain.isExpensive()    // Train의 확장함수임
    srt.isExpensive()           // Srt의 확장함수임
}

/**
 * :: 코틀린의 확장함수 ::
 * 자바와의 100% 호환성을 위해 추가된 개념
 * 기존 자바 코드 위에 코틀린 코드를 자연스럽게 추가할 수 있다.
 * 확장함수에서는 클래스에 있는 private 또는 proteced 멤버를 가져올 수 없다 (캡슐화가 깨지기 때문에)
 * 멤버함수와 함수명과 시그니쳐가 같은 경우 ->
 *
 * 여기서 this를 "수신객체" 라고 하고 this의 타입 (여기서는 String)을 "수신객체타입" 이라고 한다.
 *
 * 자바에서는 이를 정적메소드처럼 호출할 수 있다.
 *
 * 확장함수와 동일한 개념으로 확장프로퍼티를 정의하는것도 가능하다..!!
 */
fun String.lastChar(): Char = this[this.length - 1]

class Human(
    val name: String,
    val age: Int
) {
    fun nextYearAge() = age + 1
}
fun Human.nextYearAge(): Int {
    println("확장함수임")
    return this.age + 1
}

/**
 * 상속을 받는 경우
 * 해당 변수의 현재타입에 의해 어떤 확장함수가 호출될지 결정된다. (추론된 타입을 기준으로)
 */
open class Train(
    val name: String = "기본기차",
    val price: Int = 5000
)

class Srt: Train(
    "SRT기차",
    40000
)

fun Train.isExpensive(): Boolean {
    println("Train의 확장함수임")
    return this.price >= 10000
}

fun Srt.isExpensive(): Boolean {
    println("Srt의 확장함수임")
    return this.price >= 10000
}
