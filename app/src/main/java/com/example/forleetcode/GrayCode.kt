package com.example.forleetcode
//The gray code is a binary numeral system where two successive values differ in
// only one bit.
//
// Given a non-negative integer n representing the total number of bits in the c
//ode, print the sequence of gray code. A gray code sequence must begin with 0.
//
// Example 1:
//
//
//Input: 2
//Output: [0,1,3,2]
//Explanation:
//00 - 0
//01 - 1
//11 - 3
//10 - 2
//
//For a given n, a gray code sequence may not be uniquely defined.
//For example, [0,2,3,1] is also a valid gray code sequence.
//
//00 - 0
//10 - 2
//11 - 3
//01 - 1
//
//
// Example 2:
//
//
//Input: 0
//Output: [0]
//Explanation: We define the gray code sequence to begin with 0.
//             A gray code sequence of n has size = 2^n, which for n = 0 the size
// is 20 = 1.
//             Therefore, for n = 0 the gray code sequence is [0].
//
// Related Topics Backtracking

/**
 * Nick, 2020/6/3
 * [89] Gray Code
 */
class GrayCode {
    fun grayCode(n: Int): List<Int> {
        if (n <= 0) return listOf(0)

        val res: MutableList<Int> = ArrayList(2 * n)
        res.add(0)

        var addVal = 1
        repeat(n) {
            for (i in res.indices.reversed()) {
                res.add(res[i] + addVal)
            }
            addVal *= 2
        }

        return res
    }
}