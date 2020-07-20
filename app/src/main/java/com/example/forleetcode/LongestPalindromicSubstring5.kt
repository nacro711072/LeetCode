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
    //    以 i 為中心點
//    S(i, j) = s[i]..s[j]
//    S(i, j) = S(i + 1, j - 1) && s[i] == s[j]
    fun longestPalindrome(s: String): String {
        if (s.length < 2) return s
        var currentMaxResult: Series = Series(0, 0)
        for (i in 0..s.lastIndex) {

            val result1 = findPalindromic(s, i, true)
            if (result1 > currentMaxResult) {
                currentMaxResult = result1
            }
            val result2 = findPalindromic(s, i, false)
            if (result2 > currentMaxResult) {
                currentMaxResult = result2
            }
        }

        return s.substring(currentMaxResult.getStart(), currentMaxResult.getEnd() + 1)
    }

    private fun findPalindromic(
        s: String,
        mid: Int,
        ignoreCenter: Boolean
    ): Series {
        var i = 0
        val lI = if (ignoreCenter) mid - 1 else mid
        val bound = Math.min(lI, s.lastIndex - mid)

        while (i <= bound && s[lI - i] == s[mid + i]) {
            i++
        }
        i--
        return Series(lI - i, mid + i)
    }

    class Series(
        private var start: Int,
        private var end: Int
    ) {
        private fun getLength(): Int {
            return end - start + 1
        }

        fun extendBound() {
            --start
            ++end
        }

        fun getStart(): Int {
            return start
        }

        fun getEnd(): Int {
            return end
        }

        operator fun compareTo(other: Series): Int {
            return getLength().compareTo(other.getLength())
        }
    }
    /**
     *  以長度為優先
     * */
    fun longestPalindrome2(s: String): String {
        if (s.length < 2) return s
        val candidate: Array<Array<Series?>> = Array(2) { i -> (Array(s.length) { j -> Series(j, j - i) } as Array<Series?>) }
        var currentMaxSeries: Series = Series(0, 0)

        while (true) {
            val maxSeries = findExtendSeries(s, candidate, currentMaxSeries)
            if (maxSeries > currentMaxSeries) {
                currentMaxSeries = Series(maxSeries.getStart(), maxSeries.getEnd())
            } else {
                break
            }
        }

        return s.substring(currentMaxSeries.getStart(), currentMaxSeries.getEnd() + 1)
    }

    private fun findExtendSeries(
        s: String,
        candidate: Array<Array<Series?>>,
        currentMaxSeries: Series
    ): Series {
        var out = currentMaxSeries
        candidate.forEachIndexed { i, it ->
            it.forEachIndexed { j, series ->
                if (series == null) return@forEachIndexed
                val start = series.getStart()
                val end = series.getEnd()
                if (start <= 0 || end >= s.lastIndex) return@forEachIndexed

                if (s[start - 1] == s[end + 1]) {
                    series.extendBound()
                    if (series > out) {
                        out = series
                    }
                } else {
                    candidate[i][j] = null
                }
            }
        }
        return out
    }

}