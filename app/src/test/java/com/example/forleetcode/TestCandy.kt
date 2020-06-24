package com.example.forleetcode

import org.junit.Test

class TestCandy {
    val algorithm = Candy()

    @Test
    fun testCandy() {
        println(algorithm.candy(intArrayOf(1, 0))) // [2, 1], 3
        println("===")
        println(algorithm.candy(intArrayOf(2, 2, 1))) // [1, 2, 1], 4

        println("===")
        println(algorithm.candy(intArrayOf(3, 3, 1, 5, 4))) // [1, 2, 1, 2, 1], 7

    }

    @Test
    fun test101() {
        println(algorithm.candy(intArrayOf(1, 0, 1))) // [2, 1, 2], 5

    }

    @Test
    fun testUpAndEqual() {
        println(algorithm.candy(intArrayOf(1, 2, 3, 4, 4))) // [1, 2, 3, 4, 1], 11

        println(algorithm.candy(intArrayOf(1, 2, 3, 4, 4, 1))) // [1, 2, 3, 4, 2, 1], 13
    }

    @Test
    fun testPeek() {
        println(algorithm.candy(intArrayOf(1, 10, 9, 8, 7))) // [1, 4, 3, 2, 1], 11

    }

    @Test
    fun testError() {
        // [1, 2, 3, 5, 4, 3, 2, 1], 21
        println(algorithm.candy(intArrayOf(1, 2, 3, 5, 4, 3, 2 ,1)))
//        [1,2,3,5,4,3,2,1,4,3,2,1], 31
        println(algorithm.candy(intArrayOf(1, 2, 3, 5, 4, 3, 2 ,1, 4, 3, 2, 1)))
    }
}