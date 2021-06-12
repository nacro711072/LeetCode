package com.example.forleetcode

import org.junit.Test

class Test66 {
    @Test
    fun testSimple() {
        with(PlusOne66.SimpleImpl) {
            getData().forEach { data ->
                plusOne(data.array).also {
                    println("data: ${data.array.joinToString()}")
                    println("ans: ${it.joinToString()}")
                    assert(data.ans.contentEquals(it))
                }
            }
        }
    }

    private fun getData(): List<InOut> {
        return listOf(
            InOut(intArrayOf(1), intArrayOf(2)),
            InOut(intArrayOf(1, 0), intArrayOf(1, 1)),
            InOut(intArrayOf(1, 9), intArrayOf(2, 0)),
            InOut(intArrayOf(9, 9), intArrayOf(1, 0, 0))
        )
    }

    data class InOut(val array: IntArray, val ans: IntArray)

    private infix fun IntArray.ans(ans: IntArray): InOut = InOut(this, ans)
}

