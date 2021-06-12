package com.example.forleetcode

import org.junit.Test

class Test825 {
    @Test
    fun testSort() {
        val data = getData()

        with(FriendsOfAppropriateAges825.SortImpl) {
            data.forEach { data ->
                println("test case: ${data.array.joinToString(prefix = "[", postfix = "]")}")
                println("=========")
                numFriendRequests(data.array).also { ans ->
                    println(ans)
                    assert(ans == data.out)
                }
            }
        }
    }

    @Test
    fun testAccumulate() {
        val data = getData()

        with(FriendsOfAppropriateAges825.AccumulateImpl) {
            data.forEach { data ->
                println("test case: ${data.array.joinToString(prefix = "[", postfix = "]")}")
                println("=========")
                numFriendRequests(data.array).also { ans ->
                    println(ans)
                    assert(ans == data.out)
                }
            }
        }

    }


    private fun getData(): Array<InOut> {
        return arrayOf(
            InOut(intArrayOf(16, 16), 2),
            InOut(intArrayOf(16, 16, 16, 17, 17), 14),
            InOut(intArrayOf(16, 17, 18), 2),
            InOut(intArrayOf(20, 30, 100, 110, 120), 3),
            InOut(intArrayOf(118,14,7,63,103), 2)

        )
    }

    data class InOut(val array: IntArray, val out: Int)
}