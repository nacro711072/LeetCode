package com.example.forleetcode

import org.junit.Test

class Test1722 {
    @Test
    fun testSimple() {
        with(MinHDWithSwappable1722.UnionFindImpl) {
            getData().forEach { data ->
                minimumHammingDistance(data.source, data.target, data.swapArray).also {
                    println("ans: $it")
                    assert(it == data.ans)
                }
            }
        }
    }

    private fun getData(): List<InOut> {
        return arrayListOf(
            InOut(
                intArrayOf(1,2,3,4),
                intArrayOf(2,1,4,5),
                arrayOf(intArrayOf(0,1), intArrayOf(2, 3)),
                1
            ),
            InOut(
                intArrayOf(1,2,3,4),
                intArrayOf(1,3,2,4),
                arrayOf(),
                2
            ),
            InOut(
                intArrayOf(5,1,2,4,3),
                intArrayOf(1,5,4,2,3),
                arrayOf(intArrayOf(0,4), intArrayOf(4,2), intArrayOf(1,3), intArrayOf(1, 4)),
                0
            ),
            InOut(
                intArrayOf(50,46,54,35,18,42,26,72,75,47,50,4,54,21,18,18,61,64,100,14),
                intArrayOf(83,34,43,73,61,94,10,68,74,31,54,46,28,60,18,18,4,44,79,92),
                arrayOf(
                    intArrayOf(1,8),
                    intArrayOf(14,17),
                    intArrayOf(3,1),
                    intArrayOf(17,10),
                    intArrayOf(18,2),
                    intArrayOf(7,12),
                    intArrayOf(11,3),
                    intArrayOf(1,15),
                    intArrayOf(13,17),
                    intArrayOf(18,19),
                    intArrayOf(0,10),
                    intArrayOf(15,19),
                    intArrayOf(0,15),
                    intArrayOf(6,7),
                    intArrayOf(7,15),
                    intArrayOf(19,4),
                    intArrayOf(7,16),
                    intArrayOf(14,18),
                    intArrayOf(8,10),
                    intArrayOf(17,0),
                    intArrayOf(2,13),
                    intArrayOf(14,10),
                    intArrayOf(12,17),
                    intArrayOf(2,9),
                    intArrayOf(6,15),
                    intArrayOf(16,18),
                    intArrayOf(2,16),
                    intArrayOf(2,6),
                    intArrayOf(4,5),
                    intArrayOf(17,5),
                    intArrayOf(10,13),
                    intArrayOf(7,2),
                    intArrayOf(9,16),
                    intArrayOf(15,5),
                    intArrayOf(0,5),
                    intArrayOf(8,0),
                    intArrayOf(11,12),
                    intArrayOf(9,7),
                    intArrayOf(1,0),
                    intArrayOf(11,17),
                    intArrayOf(4,6),
                    intArrayOf(5,7),
                    intArrayOf(19,12),
                    intArrayOf(3,18),
                    intArrayOf(19,1),
                    intArrayOf(13,18),
                    intArrayOf(19,6),
                    intArrayOf(13,6),
                    intArrayOf(6,1),
                    intArrayOf(4,2)
                ),
                14
            )
        )

    }

    private data class InOut(
        val source: IntArray,
        val target: IntArray,
        val swapArray: Array<IntArray>,
        val ans: Int
    )
}