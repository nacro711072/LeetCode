package com.example.forleetcode

import org.junit.Test

/**
 * Nick, 2020/6/11
 *
 */
class TestTargetSum {

    @Test
    fun testTarget() {
        val algorithm = TargetSum()
//        12345, answer: 3
        println(algorithm.findTargetSumWays(IntArray(5) { i -> i + 1}, 3))
//        11111, answer: 5
        println(algorithm.findTargetSumWays(IntArray(5) { i -> 1}, 3))
//        11, answer: 2
        println(algorithm.findTargetSumWays(IntArray(2) { i -> 1}, 0))
    }
}