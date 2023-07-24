package com.lannstark.lec20

import com.lannstark.lec19.Person

/**
 * :: 코틀린의 Scope Function ::
 * (일반함수로 구현)
 * 1-1. let :: 람다의 결과를 반환 / it 사용 (생략은 불가능하지만 다른 이름을 붙일 수 있다.)
 * 1-2. run :: 람다의 결과를 반환 / this 사용 (생략이 가능하지만 다른 이름을 붙일 수 없다.)
 *
 * (확장함수로 구현)
 * 2-1. also :: 객체 그 자체를 반환 / it 사용 (생략은 불가능하지만 다른 이름을 붙일 수 있다.)
 * 2-2-. apply :: 객체 그 자체를 반환 / this 사용 (생략이 가능하지만 다른 이름을 붙일 수 없다.)
 */

// nullable한 변수를 non-null인 로직을 처리하고 싶을 때
fun printPersonLet(person: Person?) = person?.let {
    println(person.name)
    println(person.age)
    it.age
}

// 객체 초기화와 반환값 계산을 동시에 해야할 때
// ex) 객체를 DB에 바로 저장하고 이 인스턴스를 바로 활용해야하는 경우
fun printPersonRun(person: Person?) = person?.run {
    println(person.name)
    println(person.age)
//    this.age
    age
}

fun printPersonAlso(person: Person?) = person?.also {
    println(person.name)
    println(person.age)
    it.age
}

fun printPersonApply(person: Person?) = person?.apply {
    println(person.name)
    println(person.age)
    this.age
}
fun main() {

}

// 남발하면 오히려 가독성에 좋지 않으므로 적절히 사용하자..

