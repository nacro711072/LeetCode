package com.example.forleetcode

import org.junit.Test

class TestLongestValidParentheses {
    @Test
    fun testDP1() {

        val algorithm = LongestValidParentheses32()
        algorithm.longestValidParentheses("()").also {
            println(it)
            assert(it == 2)
        }
        algorithm.longestValidParentheses("((((()").also {
            println(it)
            assert(it == 2)
        }
        algorithm.longestValidParentheses("(((((").also {
            println(it)
            assert(it == 0)
        }
        algorithm.longestValidParentheses("((((()))))").also {
            println(it)
            assert(it == 10)
        }
        algorithm.longestValidParentheses("()()()").also {
            println(it)
            assert(it == 6)
        }
        algorithm.longestValidParentheses("(((()()()").also {
            println(it)
            assert(it == 6)
        }
        algorithm.longestValidParentheses("()()())))").also {
            println(it)
            assert(it == 6)
        }
        algorithm.longestValidParentheses("(((()())()").also {
            println(it)
            assert(it == 8)
        }
        algorithm.longestValidParentheses("(((()())())").also {
            println(it)
            assert(it == 10)
        }
    }

    @Test
    fun testStack() {
        val algorithm = LongestValidParentheses32()
        algorithm.longestValidParentheses2(")()())").also {
            println(it)
            assert(it == 4)
        }
    }

    @Test
    fun testDP2() {
        val algorithm = LongestValidParentheses32()
        algorithm.longestValidParentheses3(")()())").also {
            println(it)
            assert(it == 4)
        }
        algorithm.longestValidParentheses3("(((())))").also {
            println(it)
            assert(it == 8)
        }

    }
}