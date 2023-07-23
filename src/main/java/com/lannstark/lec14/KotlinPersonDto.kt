package com.lannstark.lec14


fun main() {
    val koorung = KotlinPersonDto(name = "쿠렁", age = 30)
    println("이름 ::: ${koorung.name}, 나이 ::: ${koorung.age}")
    println(koorung)
    val koorung2 = koorung.copy(age = 60)
    println(koorung2)
}

// 코틀린의 data class :: 자바의 getter, setter, equals, hashcode, copy 등의 메소드를 제공한다.
data class KotlinPersonDto(
    val name: String,
    val age: Int
)