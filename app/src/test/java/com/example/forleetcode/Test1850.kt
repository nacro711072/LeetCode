package com.example.forleetcode

import org.junit.Test

class Test1850 {
    @Test
    fun test() {
        with(MinAdjSwapsReachTheKthSmallestNum1850.instance) {
            getData().forEach { testCase ->
                getMinSwaps(testCase.nums, testCase.k).also { assert(it == 2) }
            }
        }
    }

    private fun getData(): List<TestData> {
        return arrayListOf(
            case("5489355142", 4, 2)
        )
    }
}

data class TestData(val nums: String, val k: Int, val ans: Int)

fun case(nums: String, k: Int, ans: Int): TestData = TestData(nums, k, ans)