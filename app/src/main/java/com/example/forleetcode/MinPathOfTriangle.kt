package com.example.forleetcode

//Given a triangle, find the minimum path sum from top to bottom. Each step you
//may move to adjacent numbers on the row below.
//
// For example, given the following triangle
//
//
//[
//     [2],
//    [3,4],
//   [6,5,7],
//  [4,1,8,3]
//]
//
//
// The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11).
//
// Note:
//
// Bonus point if you are able to do this using only O(n) extra space, where n i
//s the total number of rows in the triangle.
// Related Topics Array Dynamic Programming

/**
 * Nick, 2020/6/1
 * [120] Triangle
 */
class MinPathOfTriangle {
    fun minimumTotal(triangle: List<List<Int>>): Int {
        var tempList: MutableList<Int> = triangle.last().toMutableList()
        for (i in triangle.size - 2 downTo 0) {
            for (j in 0..i) {
                tempList[j] = Math.min(tempList[j], tempList[j + 1]) + triangle[i][j]
            }
        }
        return tempList[0]
    }
}