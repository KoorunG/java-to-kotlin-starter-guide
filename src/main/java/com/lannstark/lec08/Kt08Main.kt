package com.lannstark.lec08

// 코틀린의 함수문법
fun main() {
    // 1. 함수선언 문법
    println(max(10, 30))
    println(max(40, 30))

    // 2. 디폴트 파라미터
    repeat("3")
    repeat("4", 4)
    repeat("5", 5, false)

    // 3. 네임드 파라미터
    // 파라미터명을 직접 지정하여 파라미터를 입력할 수 있다.
    repeat(useNewLine = false, str = "5", num = 5)

    // ** 코틀린에서는 위의 두 함수의 특성으로 인하여 "빌더를 굳이 만들지 않아도 빌더의 효과를 볼 수 있다"
    printNameAndGender()
    printNameAndGender(gender = "남", name = "쿠렁")

    // 4. 가변인자
    printAll("A", "B", "C")
    // 가변인자에 배열을 넣을 때는 * 라는 스프레드 연산자를 붙여야한다! (타입스크립트의 ...과 비슷)
    printAll(*arrayOf("A", "B", "C"))
}


// 우선 코틀린에서는 if-else문이 Expression이기 때문에 리턴이 가능하고
// 중괄호에서 어떤 값을 return만 하는 경우
// 중괄호 마저 생략하고 = 으로 표현하는 것이 가능하다!
// 이렇게 중괄호를 생략했을 때는 return이 Int로 추론이 가능하기 때문에 반환타입마저 생략 가능하다
fun max(a: Int, b: Int) = if(a > b) a  else b


// 코틀린에서는 파이썬과 같이 디폴트 파라미터를 지정할 수 있다.
// 이렇게 구현하려면 자바에서는 메소드 오버로딩을 통해 3개의 메소드를 별도로 만들어야 했다.
fun repeat(str: String, num: Int = 3, useNewLine : Boolean = true) {
    for(i in 1..num) if(useNewLine) println(str) else print(str)
}

fun printNameAndGender(name : String = "디폴트", gender : String = "남자") {
    println("이름 :::: ${name}")
    println("성별 :::: ${gender}")
}

// 코틀린에서 가변인자를 사용할경우 파라미터 앞에 vararg 연산자를 붙여야 한다.
fun printAll(vararg strings: String) {
    for(str in strings) {
        println("str :::: $str")
    }
}