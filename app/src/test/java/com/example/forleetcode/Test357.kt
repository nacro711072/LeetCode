package com.example.forleetcode

import org.junit.Test

class Test357 {
    @Test
    fun testMathImpl() {
        with(CountNumsUniqueDigits357.MathImpl) {
            getData().forEach { data ->
                countNumbersWithUniqueDigits(data.n).also {
                    println("ans: $it")
                    assert(it == data.ans)
                }
            }
        }
    }

    private fun getData(): List<InOut> {
        return listOf(
            InOut(1, 10),
            InOut(2, 91),
            InOut(3, 739)
        )

    }
    private data class InOut(val n: Int, val ans: Int)
}