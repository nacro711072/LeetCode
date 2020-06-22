package com.example.forleetcode

import org.junit.Test

/**
 * Nick, 2020/6/22
 *
 */
class TestValidParentheses {
    @Test
    fun testValidParentheses() {
        val algorithm = ValidParentheses()
        println(algorithm.isValid("(){}"))

        println(algorithm.isValid("({)}"))
        println(algorithm.isValid("([)}"))
        println(algorithm.isValid("({})[][()]"))
    }
}