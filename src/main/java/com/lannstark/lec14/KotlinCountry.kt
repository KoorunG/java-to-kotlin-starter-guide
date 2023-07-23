package com.lannstark.lec14


// 코틀린에서 when식을 ENUM 처리에 사용할 경우 매우 유용하다...
// ENUM은 컴파일타임에 프로퍼티정보가 이미 넘어가며 코틀린의 when은 branch가 추가되면 이를 자동으로 인식해서 알려준다..!
fun handleCountry(country: KotlinCountry) = when(country) {
    KotlinCountry.KOREA -> "한국임니다"
    KotlinCountry.AMERICA -> "미국임니다"
    KotlinCountry.EUROPE -> "유럽임니다"
}
fun main() {
    println(handleCountry(KotlinCountry.KOREA))
    println(handleCountry(KotlinCountry.AMERICA))
}


// 코틀린의 ENUM 클래스는 자바와 거의 동일하다.
enum class KotlinCountry(
    val code: String
) {
    KOREA("KO"),
    AMERICA("US"),
    EUROPE("EU")
}