package com.example.forleetcode

/**
熔漿擴散

Given three parameters: A, B, and C.

A is an integer array consisting of width (W), height (H), and
specified second (N).
> A = (寬, 長, 時間)

B, a string array represents all the coordinates of the obsidian,
and each element is two integers split with a comma, e.g.
['1,2", "3,1").
> B = List<花崗岩的位置>

C, also is a string array that represents all the coordinates of
the lava at N=0, and each element is two integers split with a
comma, e.g. ["5,5", "3,1").
> C = List<熔漿起始點>

Notice that B and C are empty arrays possible.

Return Value:
Return an integer, the number of spaces left at the specified time.
> 試算最後剩下幾格空間
*/

class MinecraftLava {

    fun solveLeftSapce(a: IntArray, b: Array<String>, c: Array<String>): Int {
        val map = Array<IntArray>(a[1]) { IntArray(a[0]) { 0 } }

        b.forEach {
            val (x, y) = it.split(",").map { l -> l.toInt() }
            map[x][y] = -1
        }
        val lava = c.map {
            val (x, y) = it.split(",").map { l -> l.toInt() }
            x to y
        }

        var totalLava = 0
        lava.forEach {
            totalLava += dsf(map, it, a[2])
        }

        println(map.joinToString("\n") { it.joinToString(",") })

        return a[0] * a[1] - totalLava - b.size
    }

    private fun dsf(map: Array<IntArray>, lava: Pair<Int, Int>, step: Int): Int {
        if (step < 0) return 0
        val (x, y) = lava
        var totalLava = 0

        if (map[x][y] == 0) {
            totalLava++
            map[x][y] = 1
        }

        totalLava += nextBlock(map, x + 1, y, step)
        totalLava += nextBlock(map, x, y + 1, step)
        totalLava += nextBlock(map, x - 1, y, step)
        totalLava += nextBlock(map, x, y - 1, step)
        return totalLava
    }

    private fun nextBlock(map: Array<IntArray>, x: Int, y: Int, step: Int): Int {
        return if (x in map.indices && y in map[0].indices && map[x][y] != -1) {
            dsf(map, x to y, step - 1)
        } else {
            0
        }
    }

}