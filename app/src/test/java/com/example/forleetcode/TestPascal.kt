package com.example.forleetcode

import org.junit.Test

/**
 * Nick, 2020/6/5
 *
 */
class TestPascal {
    @Test
    fun testGetRow() {

        val pascal = Pascal()
        val testData = pascal.getRow(3)
        println(testData)
        println(pascal.getRow(4))
        println(pascal.getRow(5))
    }
}