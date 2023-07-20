package com.lannstark.lec12


fun main() {
    println(SingleTon.a)
    SingleTon.a += 10
    println(SingleTon.a)

    // 코틀린에서 익명클래스를 만들때에도 object 키워드를 사용한다.
    moveSomthing(object : Movable {
        override fun move() {
            TODO("Not yet implemented")
        }

        override fun fly() {
            TODO("Not yet implemented")
        }
    })
}

private fun moveSomthing(movable: Movable) {
    movable.move()
    movable.fly()
}
class Person private constructor (
    var name: String,
    var age: Int
) {

    // 클래스와 동행하는 "유일한 오브젝트" (즉 싱글톤)
    // 자바의 static과 동등한 의미를 지닌다...
    // companion object에는 네이밍이 가능하며 (Companion 이라는 이름이 기본적으로 생략된 형태)
    // 인터페이스를 구현하는 것도 가능하다!
    // Java에서 companion object에 접근하려면 @JvmStatic 애노테이션을 붙여줘야함..
    companion object Factory: CommonFactory {

        override fun createFactory(name: String): CommonFactory {
            println("팩토리를 생성합니다")
            return Factory  // 객체가 아니라 오브젝트임을 기억하자...
        }

        // const :: 컴파일시 변수가 할당, 상수를 선언할때 사용
        private const val MIN_AGE: Int = 1
        fun newBaby(name: String) = Person(name, MIN_AGE)
    }
}

// 그냥 object 키워드를 붙이면 싱글톤 구현 끝
object SingleTon {
    var a: Int = 0
}