package com.lannstark.lec07

import java.io.BufferedReader
import java.io.File
import java.io.FileNotFoundException
import java.io.FileReader

class KotlinFilePrinter {
    fun readFile(filename: String) {

        val root = File(".")
        val file = File("${root.absolutePath}/${filename}")

        // 코틀린에서 BufferedReader 에서 .use() 라는 확장함수를 사용하여
        // 자바의 try-with-resources 를 대체할 수 있다!
        try {
            BufferedReader(FileReader(file)).use { reader ->
                println(reader.readLine())
            }
        } catch (e: FileNotFoundException) {
            throw IllegalArgumentException("해당 파일은 존재하지 않습니다.")
        }
    }
}