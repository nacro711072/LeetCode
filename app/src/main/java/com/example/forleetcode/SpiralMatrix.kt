package com.example.forleetcode

import kotlin.collections.ArrayList

//Given a matrix of m x n elements (m rows, n columns), return all elements of t
//he matrix in spiral order.
//
// Example 1:
//
//
//Input:
//[
// [ 1, 2, 3 ],
// [ 4, 5, 6 ],
// [ 7, 8, 9 ]
//]
//Output: [1,2,3,6,9,8,7,4,5]
//
//
// Example 2:
//
//Input:
//[
//  [1, 2, 3, 4],
//  [5, 6, 7, 8],
//  [9,10,11,12]
//]
//Output: [1,2,3,4,8,12,11,10,9,5,6,7]
// Related Topics Array


/**
 * Nick, 2020/6/10
 * [54] Spiral Matrix
 * 還可以更快一點
 */
class SpiralMatrix {
    fun spiralOrder(matrix: Array<IntArray>): List<Int> {
        val numRow = matrix.size
        val numCol = matrix.getOrNull(0)?.size ?: 0
        val total = numRow * numCol

        val result = ArrayList<Int>(total)

        var i = 0
        var j = 0

        val changeX = arrayOf(1, 0, -1, 0)
        val changeY = arrayOf(0, 1, 0, -1)
        val side = arrayOf(-1, -1, numCol, numRow)
        var direction = 0

        repeat (total) {
            result.add(matrix[i][j])

            val nextX = j + changeX[direction]
            val nextY = i + changeY[direction]

            if (side[0] < nextX && nextX < side[2] && side[1] < nextY && nextY < side[3]) {
                j = nextX
                i = nextY
            } else {
                direction = (direction + 1) % 4
                side[direction] += if (direction < 2) 1 else -1
                j += changeX[direction]
                i += changeY[direction]
            }
        }

        return result
    }
}