package com.lannstark.lec18

fun main() {
    val fruits = listOf(
        Fruit(1L, "사과", 1_000L, 2_000L),
        Fruit(2L, "사과", 2_000L, 3_000L),
        Fruit(3L, "바나나", 3_000L, 4_000L),
        Fruit(4L, "수박", 4_000L, 5_000L),
        Fruit(5L, "수박", 5_000L, 6_000L),
        Fruit(6L, "멜론", 6_000L, 10_000L),
    )

    val filteredFruits = fruits.filter { fruit -> fruit.name == "사과" }
    val allFruits = fruits.all { fruit -> fruit.name == "사과" }
    val noneFruits = fruits.none { fruit -> fruit.name == "사과" }
    val anyFruits = fruits.any { fruit -> fruit.name == "사과" }
    val countFruits = fruits.count { fruit -> fruit.name == "사과" }
    val sortedByFactoryPriceFruits = fruits.sortedBy { it.factoryPrice }
    val sortedByDescendingFactoryPriceFruits = fruits.sortedByDescending { it.factoryPrice }
    val distinctedFruitByName = fruits.distinctBy { it.name }
    val firstFruit = fruits.first()
    val firstFruitOrNull = fruits.firstOrNull()
    val lastFruit = fruits.last()
    val lastFruitOrNull = fruits.lastOrNull()

    val fruitsMapByName = fruits.groupBy { it.name }
    val fruitsAssociateBy =  fruits.associateBy { it.id }
}

data class Fruit(
    val id: Long,
    val name: String,
    val factoryPrice: Long,
    val currentPrice: Long
)