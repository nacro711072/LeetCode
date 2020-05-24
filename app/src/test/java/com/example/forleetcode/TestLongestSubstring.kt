package com.example.forleetcode

import org.junit.Test

class TestLongestSubstring {

    @Test
    fun test() {
        var res = LongestSubstring()
            .lengthOfLongestSubstring("warhdf")
        println(res)
        assert(res == 6)

        res = LongestSubstring()
            .lengthOfLongestSubstring("dvdf")
        println(res)
        assert(res == 3)

        res = LongestSubstring()
            .lengthOfLongestSubstring("abba")
        println(res)
        assert(res == 2)


        res = LongestSubstring()
            .lengthOfLongestSubstring("dafgdvdfa")
        println(res)
        assert(res == 5)

    }
}