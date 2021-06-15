package com.example.forleetcode

import org.junit.Test

class Test1043 {
    @Test
    fun testSimple() {
        testWithImpl(PartitionArrForMaxSum1043.SimpleImpl)
    }

    @Test
    fun testDP() {
        testWithImpl(PartitionArrForMaxSum1043.DPImpl)
    }

    private fun testWithImpl(impl: PartitionArrForMaxSum1043) {
        with(impl) {
            getData().forEach { data ->
                maxSumAfterPartitioning(data.array, data.k).also {
                    println("array: [${data.array.joinToString()}]")
                    println("ans: $it")
                    assert(it == data.ans)
                }
            }
        }
    }

    private fun getData(): List<InOut> {
        return listOf(
            InOut(intArrayOf(1,15,7,9,2,5,10), 3, 84),
            InOut(intArrayOf(1,4,1,5,7,3,6,1,9,9,3), 4, 83),
            InOut(intArrayOf(1), 1, 1)
        )
    }

    private data class InOut(val array: IntArray, val k: Int, val ans: Int)
}