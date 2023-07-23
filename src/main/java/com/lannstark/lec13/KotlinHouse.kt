package com.lannstark.lec13

class KotlinHouse(
    private var address: String,
    private var livingRoom: LivingRoom
) {
    // 외부 클래스의 private 프로퍼티를 참조할 수 있으나 권장되지 않는다.
    // 그냥 class ... 으로 만드는것을 추천함 (코틀린에서는 기본적으로 바깥클래스를 참조하지 않는 형태로 되어있음)
    inner class LivingRoom(
        private var area: Double
    ) {
        val address: String
            get() = this@KotlinHouse.address
    }

}