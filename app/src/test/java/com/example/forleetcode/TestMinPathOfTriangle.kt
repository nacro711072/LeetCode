package com.example.forleetcode

import org.junit.Test

/**
 * Nick, 2020/6/1
 *
 */
class TestMinPathOfTriangle {
    @Test
    fun test() {
        val testData = listOf(
            listOf(2), listOf(3, 4), listOf(6, 5, 7), listOf(4, 1, 8, 3)
        )

        val algorithm = MinPathOfTriangle()
        val res = algorithm.minimumTotal(testData)
        assert(res == 11)
    }
}