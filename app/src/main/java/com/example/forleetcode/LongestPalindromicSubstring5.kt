package com.example.forleetcode
//Given a string s, find the longest palindromic substring in s. You may assume
//that the maximum length of s is 1000.
//
// Example 1:
//
//
//Input: "babad"
//Output: "bab"
//Note: "aba" is also a valid answer.
//
//
// Example 2:
//
//
//Input: "cbbd"
//Output: "bb"
//
// Related Topics String Dynamic Programming
class LongestPalindromicSubstring5 {
    fun longestPalindrome(s: String): String {
        if (s.length < 2) return s
        var currentMaxResult: Pair<Int, Int> = 0 to 0
        for (i in 0 until s.lastIndex) {

            val resultI = findPalindromic(s, i, currentMaxResult.getLength())
            if (resultI.getLength() >= currentMaxResult.getLength()) {
                currentMaxResult = resultI
            }
        }

        return s.substring(currentMaxResult.first, currentMaxResult.second + 1)
    }

    private fun findPalindromic(
        s: String,
        mid: Int,
        maxLength: Int
    ): Pair<Int, Int>{
        var i = 0
        var maxCount = Math.min(mid, s.lastIndex - mid - 1)
        if (maxLength > (maxCount + 1) * 2) return 0 to -1

        while (i <= maxCount) {
            if (s[mid - i] == s[mid + i + 1]) {
                i++
            } else {
                break
            }
        }
        val count2 = i - 1
        val result1 = mid - count2 to mid + count2 + 1

        maxCount = Math.min(mid, s.lastIndex - mid)

        var count1 = 0
        for (i in 1..maxCount) {
            if (s[mid - i] == s[mid + i]) {
                count1++
            } else {
                break
            }
        }
        val result2 = mid - count1 to mid + count1

        return if (result1.getLength() > result2.getLength()) {
            result1
        } else {
            result2
        }
    }

    private inline fun Pair<Int, Int>.getLength(): Int {
        return second - first + 1
    }
}