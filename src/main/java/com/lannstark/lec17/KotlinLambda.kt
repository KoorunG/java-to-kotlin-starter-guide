package com.lannstark.lec17


/**
 * :: 코틀린에서의 람다 ::
 * 코틀린에서는 함수가 일급시민이기 때문에 그 자체로 값이 될 수 있다!! (중요)
 */
fun main() {
   val fruits = listOf(
       Fruit("사과", 1000),
       Fruit("사과", 2000),
       Fruit("사과", 3000),
       Fruit("사과", 4000),
       Fruit("바나나", 3500),
       Fruit("바나나", 1500),
       Fruit("바나나", 2500),
       Fruit("수박", 10000),
   )
    // 코틀린의 익명함수를 값처럼 사용한 예제
    val isApple = fun(fruit: Fruit): Boolean = fruit.name == "사과"
    // 코틀린의 람다를 값처럼 사용한 예제
    val isApple2 = {fruit: Fruit -> fruit.name == "사과"}

    // 람다를 호출하는 방법 1:: 직접 호출
    println(isApple(fruits[0]))

    // 람다를 호출하는 방법 2:: invoke()
    println(isApple2.invoke(fruits[1]))

    filterFruits(fruits, isApple).let{ println(it.size)}
    filterFruits(fruits, isApple2).let{ println(it.size)}
//    filterFruits(fruits, {fruit: Fruit -> fruit.name == "바나나"})

    // 함수파라미터가 마지막에 위치해있다면 중괄호를 소괄호 밖으로 뺄 수 있다!!
    filterFruits(fruits) { fruit -> fruit.name == "바나나" }.let{ println(it.size)}
    // 함수 파라미터가 하나일 때 it 을 활용할 수 있다
    filterFruits(fruits) { it.name == "바나나" }.let{ println(it.size)}
}

/**
 * <Java코드>
 * private List<Fruit> filterFruits(List<Fruit> fruits, Predicate<Fruit> fruitFilter) {
 *     List<Fruit> results = new ArrayList<>();
 *     for (Fruit fruit : fruits) {
 *       if (fruitFilter.test(fruit)) {
 *         results.add(fruit);
 *       }
 *     }
 *     return results;
 *   }
 */
// 자바의 filterFruits 를 코틀린 코드로 Migration한 모습
private fun filterFruits(fruits: List<Fruit>, fruitFilter: (Fruit) -> Boolean)= fruits
    .filter(fruitFilter)
    .toList()