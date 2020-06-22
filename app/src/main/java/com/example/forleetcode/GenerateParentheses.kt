package com.example.forleetcode

import java.util.*
import kotlin.collections.ArrayList

//
//Given n pairs of parentheses, write a function to generate all combinations of
// well-formed parentheses.
//
//
//
//For example, given n = 3, a solution set is:
//
//
//[
//  "((()))",
//  "(()())",
//  "(())()",
//  "()(())",
//  "()()()"
//]
// Related Topics String Backtracking

/**
 * Nick, 2020/6/22
 * [22] Generate Parentheses
 */
class GenerateParentheses {
    fun generateParenthesis(n: Int): List<String> {
        if (n <= 0) return emptyList()
        val current = "("
        val result = ArrayList<String>()
        var numLeft = 1
        var numRight = 0

        generate(result, current, numLeft, numRight, n)
        return result
    }

    private fun generate(
        result: MutableList<String>,
        current: String,
        numLeft: Int,
        numRight: Int,
        n: Int
    ) {
        if (current.length >= 2 * n) {
            result.add(current)
            return
        }

        if (numLeft < n) {
            generate(result, "$current(", numLeft + 1, numRight, n)
        }
        if (numLeft > numRight) {
            generate(result, "$current)", numLeft, numRight + 1, n)
        }
    }
}