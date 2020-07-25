package com.example.forleetcode
//Write an algorithm to determine if a number n is "happy".
//
// A happy number is a number defined by the following process: Starting with an
//y positive integer, replace the number by the sum of the squares of its digits,
//and repeat the process until the number equals 1 (where it will stay), or it loo
//ps endlessly in a cycle which does not include 1. Those numbers for which this p
//rocess ends in 1 are happy numbers.
//
// Return True if n is a happy number, and False if not.
//
// Example:
//
//
//Input: 19
//Output: true
//Explanation:
//12 + 92 = 82
//82 + 22 = 68
//62 + 82 = 100
//12 + 02 + 02 = 1
//
// Related Topics Hash Table Math

class HappyNumber202 {
    private val hashSet: HashSet<Int> = HashSet()

    fun isHappy(n: Int): Boolean {
        var nn = n
        var out = 0
        while (nn != 0) {
            out += (nn % 10) * (nn % 10)
            nn /= 10
        }

        if (out == 1) return true
        if (hashSet.contains(out)) return false

        hashSet.add(out)

        return isHappy(out)
    }

}