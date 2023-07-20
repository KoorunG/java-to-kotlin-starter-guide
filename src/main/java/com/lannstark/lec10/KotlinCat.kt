package com.lannstark.lec10


// 코틀린에서의 상속은 ":" 을 사용하며 .. (1)
// 상위클래스의 생성자를 반드시 호출해야한다. .. (2)
class KotlinCat(
    species: String
): KotlinAnimal(species, 4) {   // ..(1),(2)
    override fun move() {
        println("고양이가 움직입니다.")
    }
}