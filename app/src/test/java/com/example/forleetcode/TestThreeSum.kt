package com.example.forleetcode

import org.junit.Test

class TestThreeSum {
    @Test
    fun test() {
        val algorithm = ThreeSum15()
        algorithm.threeSum(intArrayOf(-4,-2,-2,-2,0,1,2,2,2,3,3,4,4,6,6)).also {
            println(it)
        }
    }
}