package com.lannstark.lec09


fun main() {
    // data class라면 이런식으로 구조분해할당이 가능하다!
    val (name, age) = KotlinPerson(age = 30, name = "쿠렁")
    println("name :::: ${name}")
    println("age :::: ${age}")

    println(KotlinPersonWithValidation("쿠렁2", 0, null).name)
    println(KotlinPersonWithValidation("쿠렁3").age)
    println(KotlinPersonWithValidation(30).age)

}

// 코틀린에서 getter, setter은 자동으로 만들어준다.
// 코틀린의 생성자는 클래스명 바로 옆에 선언한다
// 코틀린에서 프로퍼티를 바로 지정할 수 있다.
// 위와 같이 처리했을 때 클래스 바디 안에 아무것도 없으면 중괄호 마저 생략 가능하다.
data class KotlinPerson(val name: String, val age: Int)

// 1. primary consturcor ::: 반드시 존재해야 한다. 단, 주생성자에 파라미터가 없을 경우 생략 가능하다.
class KotlinPersonWithValidation(name: String, val age: Int, address : String?) {
    // 코틀린에서는 init 이라는 특별한 블록을 사용할 수 있으며, 클래스가 초기화 되는 시점에 실행된다!
    // (마치 onBodyInit와 같이 동작... )


    init {
        println("코틀린에서는 init {} 이라는 초기화블록이 존재한다.")
        require(age >= 0) {
            throw IllegalArgumentException("나이는 ${age}일 수 없습니다!")
        }
    }

    // 2. secondary constuctor :: 있어도 되고 없어도 된다. 단, 최종적으로 this를 호출해야 한다.
    // 하나 이상의 생성자를 추가할 경우 바디에서 constructor을 사용하여 선언할 수 있다.
    // 이 때 this 키워드로 클래스 상단에서 선언한 생성자를 참조할 수 있다.
    constructor(name: String) : this(name, 1, null) {
        println("::: 코틀린에는 부생성자라는 것이 있다")
    }

    constructor(age: Int) : this("디폴트인간", age, null) {
        println("::: 부생성자는 body를 가질 수 있다")
        println("::: 하지만 코틀린에서는 부생성자 대신 디폴트 파라미터를 권장한다.")
    }

    // 1. 클래스 함수 선언법
    fun isAdult() = this.age >= 20

    // 2. 코틀린에서는 커스텀 getter 이라는 것을 선언할 수 있다..! (마치 프로퍼티인것 처럼)
    // 객체의 속성을 나타내는 것이라면 custom getter을 사용하고 아니면 함수로 처리하는 것이 깔끔하다.
    val isAdult: Boolean
        get() = this.age >= 20

    // 기존의 프로퍼티를 조작하는 것도 가능한데,
    // 이 경우 프로퍼티에 접근할 때 "field" 라는 예약어를 사용하거나, (backing field)

    val name = name
        get() = field.uppercase()

    // 이런식으로 별도의 커스텀 프로퍼티를 선언하고 this.name 과 같이 접근한다. (이게 더 깔끔)
    val uppercaseName : String
        get() = this.name.uppercase()

    // 커스텀 setter을 선언하는 방법 (이 때 변수는 var으로 선언해야 한다.)
    // 하지만 setter 자체를 지양하기 때문에 거의 쓰지는 않는다...
    var address = address
        set(value) {
            field = value?.uppercase()
        }
}
