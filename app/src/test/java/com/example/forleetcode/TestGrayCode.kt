package com.example.forleetcode

import org.junit.Test

/**
 * Nick, 2020/6/5
 *
 */
class TestGrayCode {
    @Test
    fun testGaryCode() {
        val algorithm = GrayCode()
        val testCase = algorithm.grayCode(2)
        println(testCase)
    }
}