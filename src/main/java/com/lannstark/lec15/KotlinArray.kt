package com.lannstark.lec15

// 프로덕션 레벨에서 배열은 잘 사용하지 않는다. (* 배열보다는 리스트를 사용해라 - Effect Java)
fun main() {
    val arr = arrayOf(100, 200)
    for(i in arr.indices) { // Array.indices :: 배열의 인덱스를 가져온다
        println("${i}번째 :::: ${arr[i]}")
    }

    for((i, v) in arr.withIndex()) { // Array.withIndex() :: 배열의 인덱스와 값을 같이 가져온다.
        println("${i}번째 :::: ${v}")
    }
}