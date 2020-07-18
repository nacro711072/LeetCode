package com.example.forleetcode

import org.junit.Test

class TestLongestPalindromicSubStr {
    @Test
    fun test() {
        val algorithm = LongestPalindromicSubstring5()
        algorithm.longestPalindrome("abbd").also {
            println(it)
            assert(it == "bb")
        }
        algorithm.longestPalindrome("abb").also {
            println(it)
            assert(it == "bb")
        }
        algorithm.longestPalindrome("bbbb").also {
            println(it)
            assert(it == "bbbb")
        }

        algorithm.longestPalindrome("abcba").also {
            println(it)
            assert(it == "abcba")
        }

        algorithm.longestPalindrome("aa").also {
            println(it)
            assert(it == "aa")
        }

        algorithm.longestPalindrome("").also {
            println(it)
            assert(it == "")
        }
        algorithm.longestPalindrome("ac").also {
            println(it)
            assert(it == "a")
        }

        algorithm.longestPalindrome("ccc").also {
            println(it)
            assert(it == "ccc")
        }
        println(Regex("sooos").find("azwdzwmwcqzgcobeeiphemqbjtxzwkhiqpbrprocbppbxrnsxnwgikiaqutwpftbiinlnpyqstkiqzbggcsdzzjbrkfmhgtnbujzszxsycmvipjtktpebaafycngqasbbhxaeawwmkjcziybxowkaibqnndcjbsoehtamhspnidjylyisiaewmypfyiqtwlmejkpzlieolfdjnxntonnzfgcqlcfpoxcwqctalwrgwhvqvtrpwemxhirpgizjffqgntsmvzldpjfijdncexbwtxnmbnoykxshkqbounzrewkpqjxocvaufnhunsmsazgibxedtopnccriwcfzeomsrrangufkjfzipkmwfbmkarnyyrgdsooosgqlkzvorrrsaveuoxjeajvbdpgxlcrtqomliphnlehgrzgwujogxteyulphhuhwyoyvcxqatfkboahfqhjgujcaapoyqtsdqfwnijlkknuralezqmcryvkankszmzpgqutojoyzsnyfwsyeqqzrlhzbc")?.range)
        algorithm.longestPalindrome("azwdzwmwcqzgcobeeiphemqbjtxzwkhiqpbrprocbppbxrnsxnwgikiaqutwpftbiinlnpyqstkiqzbggcsdzzjbrkfmhgtnbujzszxsycmvipjtktpebaafycngqasbbhxaeawwmkjcziybxowkaibqnndcjbsoehtamhspnidjylyisiaewmypfyiqtwlmejkpzlieolfdjnxntonnzfgcqlcfpoxcwqctalwrgwhvqvtrpwemxhirpgizjffqgntsmvzldpjfijdncexbwtxnmbnoykxshkqbounzrewkpqjxocvaufnhunsmsazgibxedtopnccriwcfzeomsrrangufkjfzipkmwfbmkarnyyrgdsooosgqlkzvorrrsaveuoxjeajvbdpgxlcrtqomliphnlehgrzgwujogxteyulphhuhwyoyvcxqatfkboahfqhjgujcaapoyqtsdqfwnijlkknuralezqmcryvkankszmzpgqutojoyzsnyfwsyeqqzrlhzbc").also {
            println(it)
            assert(it == "sooos")
        }
    }
}