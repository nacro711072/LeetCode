package com.example.forleetcode

import org.junit.Test

class TestMinecraftLava {
    @Test
    fun testSolve() {

        val testcases = listOf(
            InOut(intArrayOf(5, 5, 3), arrayOf("2,3", "3,3"), arrayOf("1,1"), 7),
            InOut(intArrayOf(10, 10, 5), arrayOf("6,2", "3,4", "7,7"), arrayOf("0,6", "5,6"), 29),
            InOut(intArrayOf(8, 4, 2), arrayOf("0,3", "3,6"), arrayOf("1,3", "2,5","2,1"), 5),
            InOut(intArrayOf(1, 8, 3), arrayOf("5,0"), arrayOf("7,0"), 5),
        )

        testcases.forEach { case ->
            val tester = MinecraftLava()
            val spaces = tester.solveLeftSapce(case.a, case.b, case.c)
            println("spaces: $spaces")
            assert(spaces == case.ans)
        }
    }

    data class InOut(
        val a: IntArray,
        val b: Array<String>,
        val c: Array<String>,
        val ans: Int
    )

}