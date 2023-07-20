package com.lannstark.lec12

interface CommonFactory {
    fun createFactory(name: String): CommonFactory
}