package com.lannstark.lec10

class KotlinPenguin(
    species: String
) : KotlinAnimal(species, 2),
    KotlinSwimable, // 인터페이스 구현 역시 콜론 뒤에 한다. 여러개를 상속이나 구현받는다면 콤마를 사용한다..
    KotlinFlyable {

    private val wingCount: Int = 2

    override fun move() {
        println("펭귄이 움직입니다 꿱꿱")
    }

    override fun act() {
        // 구현받은 인터페이스의 메소드를 가져오는 코틀린 문법
        super<KotlinSwimable>.act()
        super<KotlinFlyable>.act()

        val swimAbility: Int =  super.swimAbility + 3
    }

    // KotlinAnimal의 프로퍼티인 legCount를 오버라이드 하기 위하여
    // KotlinAnimal의 프로퍼티인 legCount을 open해야한다!
    override val legCount: Int
        get() = super.legCount + this.wingCount
}