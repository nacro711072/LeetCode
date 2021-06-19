package com.example.forleetcode

import org.junit.Test

class Test134 {
    @Test
    fun testSimpleImpl() {
        tester(GasStation134.SimpleImpl)
    }

    @Test
    fun testDiffImpl() {
        tester(GasStation134.DiffImpl)
    }

    @Test
    fun testDoubleHeadImpl() {
        tester(GasStation134.DoubleHeadImpl)
    }

    private fun tester(impl: GasStation134) {
        with(impl) {
            getData().forEach { data ->
                canCompleteCircuit(data.gas, data.cost).also {
                    println("ans: $it")
                    assert(data.ans == it)
                }
            }

        }
    }

    private fun getData(): List<InOut> {
        return listOf(
            InOut(intArrayOf(1,2,3,4,5), intArrayOf(3,4,5,1,2), 3),
            InOut(intArrayOf(2,3,4), intArrayOf(3,4,3), -1)
        )
    }

    private data class InOut(val gas: IntArray, val cost: IntArray, val ans: Int)
}