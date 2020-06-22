package com.example.forleetcode

import java.util.*
import kotlin.collections.ArrayDeque

//Given a string containing just the characters '(', ')', '{', '}', '[' and ']',
// determine if the input string is valid.
//
// An input string is valid if:
//
//
// Open brackets must be closed by the same type of brackets.
// Open brackets must be closed in the correct order.
//
//
// Note that an empty string is also considered valid.
//
// Example 1:
//
//
//Input: "()"
//Output: true
//
//
// Example 2:
//
//
//Input: "()[]{}"
//Output: true
//
//
// Example 3:
//
//
//Input: "(]"
//Output: false
//
//
// Example 4:
//
//
//Input: "([)]"
//Output: false
//
//
// Example 5:
//
//
//Input: "{[]}"
//Output: true
//
// Related Topics String Stack
/**
 * Nick, 2020/6/22
 * [20] Valid Parentheses
 */
class ValidParentheses {

    private val pair = mapOf(
        '(' to ')',
        '[' to ']',
        '{' to '}'
    )

    fun isValid(s: String): Boolean {
        if (s.length % 2 != 0) return false

        val stack = Stack<Char>()
        for (ch in s) {
            if (pair.keys.contains(ch)) {
                stack.push(pair[ch])
            } else {
                if (stack.isEmpty()) return false
                if (stack.pop() != ch) return false
            }
        }

        return stack.isEmpty()
    }


}