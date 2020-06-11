package com.example.forleetcode

import org.junit.Test

/**
 * Nick, 2020/6/10
 *
 */
class TestSpiralMatrix {
    @Test
    fun testMatrix1 () {
        val spiralMatrix = SpiralMatrix()

        val test1 = arrayOf(IntArray(5) { i -> i + 1})
        println(spiralMatrix.spiralOrder(test1))

        val test2 = arrayOf(IntArray(1) { i -> i + 1})
        println(spiralMatrix.spiralOrder(test2))

        val test3 = arrayOf(IntArray(3) { i -> i + 1}, IntArray(3) { i -> i + 10})
        println(spiralMatrix.spiralOrder(test3))
    }
}