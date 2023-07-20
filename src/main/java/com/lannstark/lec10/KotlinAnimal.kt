package com.lannstark.lec10

// 코틀린으로 추상클래스 구현
abstract class KotlinAnimal(
    protected val species: String,

    // 상속을 허용해야 하기 때문에 open을 붙임
    protected open val legCount: Int
) {
    abstract fun move()
}