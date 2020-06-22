package com.example.forleetcode

import org.junit.Test

/**
 * Nick, 2020/6/22
 *
 */
class TestGenerateParentheses {
    @Test
    fun testGenerateParentheses() {
        val algorithm = GenerateParentheses()
        println(algorithm.generateParenthesis(3))

        println(algorithm.generateParenthesis(2))
    }
}