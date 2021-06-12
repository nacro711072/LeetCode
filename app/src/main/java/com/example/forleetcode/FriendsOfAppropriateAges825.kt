package com.example.forleetcode

/*
Some people will make friend requests. The list of their ages is given and ages[i] is the age of the ith person.

Person A will NOT friend request person B (B != A) if any of the following conditions are true:

    age[B] <= 0.5 * age[A] + 7
    age[B] > age[A]
    age[B] > 100 && age[A] < 100

Otherwise, A will friend request B.

Note that if A requests B, B does not necessarily request A.  Also, people will not friend request themselves.

How many total friend requests are made?

Example 1:

Input: [16,16]
Output: 2
Explanation: 2 people friend request each other.

Example 2:

Input: [16,17,18]
Output: 2
Explanation: Friend requests are made 17 -> 16, 18 -> 17.

Example 3:

Input: [20,30,100,110,120]
Output: 3
Explanation: Friend requests are made 110 -> 100, 120 -> 110, 120 -> 100.



Notes:

    1 <= ages.length <= 20000.
    1 <= ages[i] <= 120.


 */
sealed class FriendsOfAppropriateAges825 {

    abstract fun numFriendRequests(ages: IntArray): Int

    object SortImpl: FriendsOfAppropriateAges825() {
        override fun numFriendRequests(ages: IntArray): Int {
            var count = 0
            val point = 14

            ages.sort() // N logN
            var i = ages.lastIndex
            while (i > 0) { // N
                val upperB = ages[i]
                if (upperB <= point) break
                val lowerB = condition(ages[i])

                var same = 0
                var otherCount = 0
                var j = i - 1
                while (j > -1) {
                    if (ages[i] == ages[j]) {
                        otherCount++
                        same++
                        j--
                    } else if (lowerB < ages[j]) {
                        otherCount++
                        j--
                    } else {
                        break
                    }
                }
                count += (same + 1) * otherCount

                i -= (same + 1)
            }
            return count
        }
    }

    object AccumulateImpl: FriendsOfAppropriateAges825() {
        override fun numFriendRequests(ages: IntArray): Int {
            var count = 0
            val point = 14

            val countArray = IntArray(121) { 0 }
            for (age in ages) {
                countArray[age]++
            }

            val accumulateCount = IntArray(121)
            for (i in 1..countArray.lastIndex) {
                accumulateCount[i] = accumulateCount[i - 1] + countArray[i]
            }

            for (i in (point..countArray.lastIndex).reversed()) {
                if (countArray[i] == 0) continue

                val lower = condition(i).toInt()
                val willRequestPeople = (accumulateCount[i] - accumulateCount[lower] - 1).coerceAtLeast(0)
                count += countArray[i] * willRequestPeople
            }
            return count
        }

    }

    internal fun condition(b: Int): Double {
        return (0.5 * b + 7)
    }

    internal fun invCondition(b: Int): Int {
        return 2 * (b - 7)
    }
}