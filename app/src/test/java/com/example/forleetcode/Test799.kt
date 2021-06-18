package com.example.forleetcode

import org.junit.Test

class Test799 {
    @Test
    fun testFirstImpl() {
        with(ChampagneTower799.FirstImpl) {
            getData().forEach { data ->
                champagneTower(data.poured, data.row, data.col).also {
                    println("ans: $it")
                    assert(it == data.ans)
                }
            }
        }
    }

    @Test
    fun testOptFirstImpl() {
        with(ChampagneTower799.OptFirstImpl) {
            getData().forEach { data ->
                champagneTower(data.poured, data.row, data.col).also {
                    println("ans: $it")
                    assert(it == data.ans)
                }
            }
        }
    }

    private fun getData(): List<InOut> {
        return listOf(
            InOut(1, 1, 1, 0.0),
            InOut(2, 1, 1, 0.5),
            InOut(100000, 21, 11, 1.0),
            InOut(100000009, 33, 17, 1.0)
        )
    }

    private class InOut(val poured: Int, val row: Int, val col: Int, val ans: Double)
}
