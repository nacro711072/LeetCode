package com.example.forleetcode

class Power50 {
    fun myPow(x: Double, n: Int): Double {
        if (x == 1.0 || n == 0) return 1.0
        if (n % 2 == 0) return myPow(x * x, n / 2)
        if (n > 0) return myPow(x, n - 1) * x
        if (n < 0) return myPow(x, n + 1) / x
        return 1.0
    }
}