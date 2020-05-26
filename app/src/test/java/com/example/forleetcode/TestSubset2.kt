package com.example.forleetcode

import org.junit.Test

/**
 * Nick, 2020/5/26
 *
 */
class TestSubset2 {

    @Test
    fun test() {
        val algorithm = SubSets2()
        var intArray = intArrayOf(1, 2, 2)
        var result = algorithm.subsetsWithDup(intArray)
        println(result)

        intArray = intArrayOf(1, 1, 2, 2)
        result = algorithm.subsetsWithDup(intArray)
        println(result)
    }
}