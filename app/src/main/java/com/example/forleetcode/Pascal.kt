package com.example.forleetcode

/**
 * Nick, 2020/6/5
 *
 */
class Pascal {
    //Given a non-negative index k where k ≤ 33, return the kth index row of the Pas
    //cal's triangle.
    //
    // Note that the row index starts from 0.
    //
    //
    //In Pascal's triangle, each number is the sum of the two numbers directly above
    // it.
    //
    // Example:
    //
    //
    //Input: 3
    //Output: [1,3,3,1]
    //
    //
    // Follow up:
    //
    // Could you optimize your algorithm to use only O(k) extra space?
    // Related Topics Array
// 數學算法
    fun getRow(rowIndex: Int): List<Int> {
        val res: MutableList<Int> = ArrayList(rowIndex + 1)
        var temp: Long = 1
        res.add(temp.toInt())
        for (i in 1..rowIndex) {
            if (i < rowIndex / 2 + 1) {
                temp = temp * (rowIndex - (i - 1)) / i
                res.add(temp.toInt())
            } else {
                res.add(res[rowIndex - i])
            }
        }
        return res
    }

    // TODO: 2020/6/5 單純程式解 
    fun getRow2(rowIndex: Int): List<Int> {
        val res: MutableList<Int> = ArrayList(rowIndex + 1)

        repeat(rowIndex + 1) {
            for (i in res.indices.reversed()) {
                if (i != 0) {
                    res[i] += res[i - 1]
                }
            }
            res.add(1)
        }

        return res
    }

}