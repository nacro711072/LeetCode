package com.example.forleetcode

import kotlin.math.max

class LongestSubstring {
    fun lengthOfLongestSubstring(s: String): Int {
        if (s.isEmpty()) return 0
        val tempStr = HashMap<Char, Int>()

        var result = 0
        var tempMinPosition = 0
        s.forEachIndexed { index, char ->
            if (tempStr.contains(char)) {
                val currentSize = index - tempMinPosition
                if (currentSize > result)
                    result = currentSize

                val oldPosition = tempStr[char]!! + 1
                if (oldPosition > tempMinPosition)
                    tempMinPosition = oldPosition
            }
            tempStr[char] = index

        }
        val lastLength = s.length - tempMinPosition
        return if (result > lastLength) result else lastLength
    }

//    fun lengthOfLongestSubstring(s: String): Int {
//
//        val tempStr = HashMap<Char, Int>()
//        var startIndex = 0
//        var endIndex = 0
//        var result = 0
//        s.forEachIndexed { index, c ->
//            endIndex = index
//            if (tempStr.contains(c)) {
//                startIndex = max(tempStr[c]!!, startIndex)
//                val interval = endIndex - startIndex
//                result = max(result, interval)
//            }
//            tempStr[c] = index
//        }
//
//        val interval = endIndex - startIndex
//        result = max(result, interval)
//
//        return result
//    }

}