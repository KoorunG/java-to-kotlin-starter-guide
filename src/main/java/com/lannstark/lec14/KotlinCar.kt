package com.lannstark.lec14

// 상속이 가능한 클래스이나 외부에서는 이 클래스를 상속받지 않도록 처리할때 사용
// 하위클래스는 같은 패키지에 있어야 한다.
// Enum과 기능상 비슷하나 차이점은
// 1. 클래스를 상속받을 수 있다.
// 2. 하위클래스는 멀티 인스턴스가 가능하다. (Enum은 싱글톤임)

//abstract class KotlinCar

fun main() {
    handleCar(Avante())
    handleCar(Sonata())
    handleCar(Grandeur())
}

fun handleCar(car: KotlinCar) = when(car) {
    is Avante -> "아반떼임니다"
    is Grandeur -> "그랜져임니다"
    is Sonata -> "소나타임니다"
}
sealed class KotlinCar(
    val name: String,
    val price: Long
)

class Avante: KotlinCar("아반떼", 1_000L)
class Sonata: KotlinCar("소나타", 2_000L)
class Grandeur: KotlinCar("그랜져", 3_000L)