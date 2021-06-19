package com.example.forleetcode

/* 134. Gas Station
There are n gas stations along a circular route, where the amount of gas at the ith station is gas[i].

You have a car with an unlimited gas tank and it costs cost[i] of gas to travel from the ith station to its next (i + 1)th station. You begin the journey with an empty tank at one of the gas stations.

Given two integer arrays gas and cost, return the starting gas station's index if you can travel around the circuit once in the clockwise direction, otherwise return -1. If there exists a solution, it is guaranteed to be unique



Example 1:

Input: gas = [1,2,3,4,5], cost = [3,4,5,1,2]
Output: 3
Explanation:
Start at station 3 (index 3) and fill up with 4 unit of gas. Your tank = 0 + 4 = 4
Travel to station 4. Your tank = 4 - 1 + 5 = 8
Travel to station 0. Your tank = 8 - 2 + 1 = 7
Travel to station 1. Your tank = 7 - 3 + 2 = 6
Travel to station 2. Your tank = 6 - 4 + 3 = 5
Travel to station 3. The cost is 5. Your gas is just enough to travel back to station 3.
Therefore, return 3 as the starting index.

Example 2:

Input: gas = [2,3,4], cost = [3,4,3]
Output: -1
Explanation:
You can't start at station 0 or 1, as there is not enough gas to travel to the next station.
Let's start at station 2 and fill up with 4 unit of gas. Your tank = 0 + 4 = 4
Travel to station 0. Your tank = 4 - 3 + 2 = 3
Travel to station 1. Your tank = 3 - 3 + 3 = 3
You cannot travel back to station 2, as it requires 4 unit of gas but you only have 3.
Therefore, you can't travel around the circuit once no matter where you start.



Constraints:

    gas.length == n
    cost.length == n
    1 <= n <= 104
    0 <= gas[i], cost[i] <= 104


 */
sealed class GasStation134 {
    abstract fun canCompleteCircuit(gas: IntArray, cost: IntArray): Int

    object SimpleImpl: GasStation134() {
        override fun canCompleteCircuit(gas: IntArray, cost: IntArray): Int {
            for (i in gas.indices) {
                if (gas[i] > cost[i]) {
                    if (tryCircle(gas, cost, i)) {
                        return i
                    }
                }
            }
            return -1
        }

        private fun tryCircle(gas: IntArray, cost: IntArray, i: Int): Boolean {
            var tank = gas[i]
            for (j in i..(i + gas.size)) {
                val realI = i % gas.size
                val realNextI = (i + 1) % gas.size
                if (tank < cost[realI]) return false
                tank = tank - cost[realI] + realNextI
            }
            return true
        }
    }

    object DiffImpl: GasStation134() {
        override fun canCompleteCircuit(gas: IntArray, cost: IntArray): Int {
//            diff gas and cost
            val leftTank = IntArray(gas.size)
            var leftSum = 0
            for (i in gas.indices) {
                leftTank[i] = gas[i] - cost[i]
                leftSum += leftTank[i]
            }
            if (leftSum < 0) return -1

//            try journey circle begin with gas[start]
            val begin = IntArray(gas.size) { -1 }
            for (start in gas.indices) {
                if (leftTank[start] < 0) continue

                begin[start] = leftTank[start]
                for (cirIndex in (start + 1)..(start + gas.size)) {
                    if (begin[start] < 0) break
                    begin[start] += leftTank[cirIndex % gas.size]
                }
                if (begin[start] >= 0) return start
            }

            return -1
        }
    }

    object DoubleHeadImpl: GasStation134() {
        override fun canCompleteCircuit(gas: IntArray, cost: IntArray): Int {
//            diff gas and cost
            val leftTank = IntArray(gas.size)
            var leftSum = 0
            for (i in gas.indices) {
                leftTank[i] = gas[i] - cost[i]
                leftSum += leftTank[i]
            }
            if (leftSum < 0) return -1

//            if enough
//                keep journey,
//            else
//                change start station (start + 1)
            var accumulate = leftTank[0]
            var start = 0
            var journey = 1
            while (start < gas.size && journey < gas.size) {
                if (accumulate >= 0) {
                    accumulate += leftTank[(start + journey) % gas.size]
                    journey++
                } else {
                    accumulate -= leftTank[start]
                    start++
                    journey--
                }
            }
            if (journey == gas.size) return start

            return -1
        }
    }
}