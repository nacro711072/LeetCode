package com.example.forleetcode
//There are N children standing in a line. Each child is assigned a rating value
//.
//
// You are giving candies to these children subjected to the following requireme
//nts:
//
//
// Each child must have at least one candy.
// Children with a higher rating get more candies than their neighbors.
//
//
// What is the minimum candies you must give?
//
// Example 1:
//
//
//Input: [1,0,2]
//Output: 5
//Explanation: You can allocate to the first, second and third child with 2, 1,
//2 candies respectively.
//
//
// Example 2:
//
//
//Input: [1,2,2]
//Output: 4
//Explanation: You can allocate to the first, second and third child with 1, 2,
//1 candies respectively.
//             The third child gets 1 candy because it satisfies the above two c
//onditions.
//
// Related Topics Greedy
/**
 * Nick
 * [135] Candy
 * 雖然跑最快, 但code 可讀性有點, 需調整
 */
class Candy {
    fun candy(ratings: IntArray): Int {
        if (ratings.size < 0) return 0
        if (ratings.size == 1) return 1

        var result = 1
        var accumulate = 1
        var mode: Int =  ratings[1].compareTo(ratings[0])
        var peek: Int? = null

        for (i in 1 until ratings.size) {
            val newMode = ratings[i].compareTo(ratings[i - 1])
            if (mode != newMode) {
                peek?.also {
                    if (accumulate >= it) {
                        result += accumulate - it + 1
                    }
                }

                peek = when {
                    mode > 0 -> {
                        accumulate
                    }
                    else -> {
                        null
                    }
                }

                if (mode < 0 && newMode > 0) {
                    accumulate = 1
                } else if (mode > 0 && newMode < 0) {
                    accumulate = 0
                } else if (newMode == 0) {
                    accumulate = 1
                }
                mode = newMode
            }

            if (mode == 0) {
                result++
            } else {
                result += (++accumulate)
            }
        }

        peek?.also {
            if (accumulate >= peek) {
                result += accumulate - peek + 1
            }
        }
        return result
    }

}