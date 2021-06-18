package com.example.forleetcode

import com.example.forleetcode.util.parse2DList_List
import org.junit.Test

class Test1202 {
    @Test
    fun testUnionFind() {
        with(SmallestStrSwap1202.UnionFindImpl) {
            getData().forEach { data ->
                println("=== case: ${data.s} ===")
                smallestStringWithSwaps(data.s, data.swapPairs).also {
                    val i = IntArray(it.length) { i -> i % 10 }
                    println("orderI: ${i.joinToString("")}")
                    println("answer: $it")
                    println("expect: ${data.ans}")
                    assert(it == data.ans)
                }
            }
        }
    }

    private fun getData(): List<InOut> {
        return listOf(
            InOut("dcab", listOf(listOf(0, 3), listOf(1, 2)), "bacd"),
            InOut("dcab", listOf(listOf(0, 3), listOf(1, 2), listOf(0, 2)), "abcd"),
            InOut("cba", listOf(listOf(0, 1), listOf(1, 2)), "abc"),
            InOut(
                "yhiihxbordwyjybyt",
                "[[9,1],[5,11],[9,7],[2,7],[14,16],[6,16],[0,5],[12,9],[6,5],[9,10],[4,7],[3,2],[10,1],[3,15],[12,4],[10,10],[15,12]]".parse2DList_List(),
                "bdhhibtirjoxwyyyy"
            )
        )
    }

    internal data class InOut(val s: String, val swapPairs: List<List<Int>>, val ans: String)
}