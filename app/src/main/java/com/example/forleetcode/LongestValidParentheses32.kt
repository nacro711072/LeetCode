package com.example.forleetcode

import java.util.*
import kotlin.collections.ArrayList

//Given a string containing just the characters '(' and ')', find the length of
//the longest valid (well-formed) parentheses substring.
//
// Example 1:
//
//
//Input: "(()"
//Output: 2
//Explanation: The longest valid parentheses substring is "()"
//
//
// Example 2:
//
//
//Input: ")()())"
//Output: 4
//Explanation: The longest valid parentheses substring is "()()"
//
// Related Topics String Dynamic Programming

class LongestValidParentheses32 {
//  dp: 以中心點"()"展開
    fun longestValidParentheses(s: String): Int {
        if (s.length < 2) return 0

        val rangeList: MutableList<Range> = ArrayList(s.length shr 1)

        var i = 0
        while (i < s.lastIndex) {
            if (s[i] == '(' && s[i + 1] == ')') {
                if (rangeList.isNotEmpty()) {
                    val last = rangeList.last()
                    if (last.end + 1 == i) {
                        last.end = i + 1
                    } else {
                        rangeList.add(Range(i, i + 1))
                    }
                } else {
                    rangeList.add(Range(i, i + 1))
                }
                i += 2
            } else {
                ++i
            }
        }


        if (rangeList.isEmpty()) return 0


        while (extendRange(s, rangeList)) {
            continue
        }

        val result = rangeList.maxBy {
            it.getLength()
        }

        return result?.getLength() ?: 0
    }

    private fun extendRange(s: String, rangeList: MutableList<Range>): Boolean {
        var isChange = false
        val it = rangeList.iterator()
        var pre: Range? = null
        while (it.hasNext()) {
            val centerRange = it.next()

            val l = centerRange.start - 1
            val r = centerRange.end + 1

            if (l >= 0  && s[l] == '(' &&
                r < s.length && s[r] == ')'
            ) {
                centerRange.start = l
                centerRange.end = r

                isChange = true
            }

            pre?.let { previous ->
                if (previous.end + 1 == centerRange.start) {
                    previous.end = centerRange.end
                    it.remove()
                } else {
                    pre = centerRange
                }
            } ?: kotlin.run {
                pre = centerRange
            }
        }
        return isChange
    }

    data class Range(var start: Int, var end: Int) {
        fun getLength(): Int = end - start + 1
    }

//  stack
    fun longestValidParentheses2(s: String): Int {
        val stack: Stack<Int> = Stack()
        stack.push(-1)
        var max = 0

        s.forEachIndexed { i, ch ->
            if (ch == '(') {
                stack.push(i)
            } else {
                stack.pop()
                when {
                    stack.isNotEmpty() -> {
                        max = max.coerceAtLeast(i - stack.peek())
                    }
                    else -> stack.push(i)
                }
            }
        }
        return max
    }
//    dp[i]: 最大合法的Parentheses長度, i in [0, s.lastIndex]
//    dp[i] = dp[i - 2] + 2, if s[i] == ')', s[i - 1] == '(',
//    即為字串是".....()"的形式
//    dp[i] = dp[i - 1] + dp[i - d[i - 1] - 2] + 2, if s[i] == ')', s[i - 1] == ')', s[i - d[i - 1] - 1] == '('
//    ,即為字串是"...(......))"的形式
    fun longestValidParentheses3(s: String): Int {
        val dp = Array(s.length) { 0 }
        var max = 0
        for (i in 1..s.lastIndex) {
            if (s[i] == ')') {
                if (s[i - 1] == '(') {
                    dp[i] = dp.getOrElse(i - 2) { 0 } + 2
                } else if (s.getOrNull(i - dp[i - 1] - 1) == '('){
                    val previous = dp[i - 1]
                    dp[i] = previous + dp.getOrElse(i - previous - 2) { 0 } + 2
                }
                max = max.coerceAtLeast(dp[i])
            }
        }
        return max
    }
}

