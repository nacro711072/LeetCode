package com.example.forleetcode

import org.junit.Test

class TestRotateArray {
    @Test
    fun rotateArray() {
        val algorithm = RotateArray189()

        val test1 = intArrayOf(1, 2, 3, 4, 5, 6, 7)
        algorithm.rotate2(test1, 3)
        println(test1.joinToString(prefix = "[", postfix = "]"))

        val test2 = intArrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
        algorithm.rotate2(test2, 4)
        println(test2.joinToString(prefix = "[", postfix = "]"))

        val test3 = IntArray(27) { it + 1 }
        algorithm.rotate2(test3, 38)
        println(test3.joinToString(prefix = "[", postfix = "]"))

    }
}