package com.lannstark.lec19

// 코틀린에서는 import할때 as로 별칭을 지정할 수 있다.
import com.lannstark.lec18.Fruit as TestFruit

// 코틀린에서는 typealias 키워드를 이용하여 커스텀 타입을 정의할 수 있다. (타입스크립트의 type과 비슷...?)
typealias FruitFilter = (TestFruit) -> Boolean

fun filterFruits(fruits: List<TestFruit>, filter: FruitFilter) {
}

typealias TMap = Map<String, TooMuchLongStringType>

data class TooMuchLongStringType(
    val name: String
)

// 코틀린의 data class는 componentN 이라는 함수가 자동으로 만들어지기 때문에
// 객체를 구조분해 하는것이 가능하다!
class Person(
    val name: String,
    val age: Int,
    val address: String? = null
) {
    // data class가 아니라면 componentN 함수를 직접 구현해서 객체구조분해를 사용하는 것이 가능하다.
    operator fun component1(): String = this.name
    operator fun component2(): Int = this.age
    operator fun component3(): String? = this.address
}

fun main() {
    val person = Person("쿠렁", 30, "원주")
    val (name, age, address) = person
    println("name :: $name, age :: $age, address :: $address")

    val numbers = listOf(1, 2, 3, 4, 5)
//    numbers.forEach {
//        if(it == 3) break
//        println(it)
//    }

    // 자바와 마찬가지로 forEach문에서 break나 continue 키워드를 사용할 수 없다.
    // 그러나 run {} 블록으로 감싸고 @run, @forEach를 활용하면 break나 continue의 기능을 구현하는 것도 가능은 하다.
    run {
        numbers.forEach {
            if(it == 3) {
//                return@run        // == break의 의미
                return@forEach      // == continue의 의미
            }
            println(it)
        }
    }

    // 코틀린에는 라벨이라는 기능이 있으며
    // 라벨을 활용하여 중첩 for문을 한번에 빠져나오는 등의 동작이 가능하다.
    // 이런게 있다는 정도로만 알아두자
    labelTest1@ for(i in 1..100) {
        labelTest2@ for(j in 1..100) {
            if(j == 2) {
//                break@labelTest
                continue@labelTest2
            }
        }
    }
}

// takeIf = 주어진 조건을 만족하면 그 값이, 아니면 null이 반환된다. (?. 호출과 비슷...?)
fun getNumberOrNull(number: Int): Int? = number.takeIf { it > 0 }

// takeUnless = 주어진 조건을 만족하지 않으면 그 값이, 아니면 null이 반환된다.
fun getNumberOrNull2(number: Int): Int? = number.takeUnless { it > 0 }



