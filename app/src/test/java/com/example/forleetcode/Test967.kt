package com.example.forleetcode

import org.junit.Test

class Test967 {
    @Test
    fun testDFSImpl() {
        with(NumsWithSameConsecutiveDiff967.RecursiveImpl) {
            getData().forEach { data ->
                println("n: ${data.n}, k: ${data.k}")
                println("expected: [${data.ans.joinToString()}]")
                numsSameConsecDiff(data.n, data.k).also {
                    it.sort()
                    println("ans: [${it.joinToString()}]")
                    assert(it.contentEquals(data.ans))
                }
            }
        }
    }

    @Test
    fun testBFSImpl() {
        with(NumsWithSameConsecutiveDiff967.BFSImpl) {
            getData().forEach { data ->
                println("n: ${data.n}, k: ${data.k}")
                println("expected: [${data.ans.joinToString()}]")
                numsSameConsecDiff(data.n, data.k).also {
                    it.sort()
                    println("ans: [${it.joinToString()}]")
                    assert(it.contentEquals(data.ans))
                }
            }
        }
    }


    fun getData(): List<InOut> {
        return listOf(
            InOut(3, 1, intArrayOf(
                101,121,123,210,212,232,234,321,323,343,345,432,434,454,456,543,545,565,567,654,656,676,678,765,767,787,789,876,878,898,987,989
            )),
            InOut(2, 1, intArrayOf(
                10,12,21,23,32,34,43,45,54,56,65,67,76,78,87,89,98
            )),
            InOut(2, 0, intArrayOf(
                11,22,33,44,55,66,77,88,99
            ))

        )
    }

    data class InOut(val n: Int, val k: Int, val ans: IntArray)
}