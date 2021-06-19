package com.example.forleetcode

sealed class CountNumsUniqueDigits357 {
    abstract fun countNumbersWithUniqueDigits(n: Int): Int

    object MathImpl: CountNumsUniqueDigits357() {
        override fun countNumbersWithUniqueDigits(n: Int): Int {
            if (n == 0) return 0
            if (n == 1) return 10
            var result = 10
            var uniqueCount = 9
            var i = 1
            while (i < n) {
                uniqueCount *= (10 - i)
                result += uniqueCount
                i++
            }
            return result
        }
    }
}