package com.lannstark.lec15

// 코틀린은 기본적으로 불변컬렉션이며, 가변으로 생성할 시 MutableXXX로 선언한다.
// 불변 컬렉션이라도 요소를 바꾸는 것은 가능하다.

fun main() {
    val prices = listOf(100, 200, 300)
    for((i, v) in prices.withIndex()) {
        println("${i} 번째 ::: ${v}")
    }

    // 빈 배열을 선언할 때 emptyXXX 사용
    // 타입추론이 가능하다면 제네릭 타입을 생략하는 것도 가능하다. (함수의 파라미터 등으로...)
    val emptyPrices = emptyList<Int>()
    println(emptyPrices)

    var mutablePrices = mutableListOf(400, 500, 600)
    for(i in mutablePrices.subList(0, 2)) {
        println(i)
    }

    // 코틀린에서 Map은 Pair 객체를 받는다.
    // to 키워드를 사용해서 Pair 객체를 바로 생성할 수 있다.
    val map = mapOf(1 to "MONDAY", 2 to "TUESDAY", 3 to "WEDNESDAY")

    for((k, v) in map.entries) {
        println("key ::: ${k}, value ::: ${v}")
    }

    /**
     * 컬렉션에도 역시 null 가능성에 대한 정보를 표기할 수 있다.
     *
     *  1. List<Int?> :: 리스트에 null이 들어갈 수 있음, 리스트는 null이 아님
     *  2. List<Int>? :: 리스트에 null이 들어갈 수 없음, 리스트는 null일 수 있음
     *  3. List<Int?>? :: null이 들어갈 수 도 있고 리스트가 null일 수 있음
     */

    /**
     * 기본적으로 코틀린의 컬렉션은 불변인 반면, 자바는 따로 구분하지 않는다.
     * 또한 자바는 별도로 nullable에 대해 처리하지 않는다.
     * 따라서
     * 1. Kotlin의 컬렉션이 Java에서 호출하는 경우
     * "컬렉션이 변경될 수 있음" 을 인지해야 한다.
     *
     * 2. 반대로 코틀린에서 Java 컬렉션을 가져오는 경우 (플랫폼타입) nullalbe에 대한 처리를 해야하기 때문에
     * nullable에 대한 별도의 처리를 하거나 코틀린 코드로 wrapping 해야한다.
     */
}