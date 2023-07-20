package com.lannstark.lec11

/**
 * A. 코틀린 클래스, 멤버의 가시성제어
 *
 * 1. public : 자바와 동일
 * 2. protected : "선언된 클래스" 또는 하위 클래스에서 접근가능 (코틀린에서는 패키지를 namespace 관리를 위해서만 사용된다..)
 * 3. internal : 같은 모듈에서(한번에 컴파일되는 코틀린 코드) 접근 가능
 * 4. private : 자바와 동일
 *
 * ** 자바의 기본 접근제어자는 default이지만
 * ** 코틀린의 기본 접근제어자는 public이다
 *  ===================================================================================================
 * B. 코틀린 파일의 가시성제어
 *
 * 1. public : 공통
 * 2. protected : 파일에는 사용할 수 없다
 * 3. internal : 같은 모듈에서만 접근 가능
 * 4. private : 같은 파일에서만 접근 가능
 *  ===================================================================================================
 *
 *  C. 코틀린 생성자의 가시성제어
 *
 *
 */

// 코틀린은 일급함수이기 때문에 정적함수를 선언할 때 파일 최상단에 바로 선언하는것이 가능하다!!
fun isDirectoryPath(path: String) = path.endsWith("/")


// 코틀린의 프로퍼티에 가시성제어
class Car (
    private val name: String,
    internal val owner: String,
    _price: Int
) {
    var price = _price
        private set
}