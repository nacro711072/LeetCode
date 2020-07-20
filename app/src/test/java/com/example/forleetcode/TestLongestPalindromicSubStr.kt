package com.example.forleetcode

import org.junit.Test

class TestLongestPalindromicSubStr {
    @Test
    fun test1() {
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

    @Test
    fun test2() {
        val algorithm = LongestPalindromicSubstring5()
//        algorithm.longestPalindrome2("abbd").also {
//            println(it)
//            assert(it == "bb")
//        }
//        algorithm.longestPalindrome2("abb").also {
//            println(it)
//            assert(it == "bb")
//        }
//        algorithm.longestPalindrome2("bbbb").also {
//            println(it)
//            assert(it == "bbbb")
//        }
//
//        algorithm.longestPalindrome2("abcba").also {
//            println(it)
//            assert(it == "abcba")
//        }
//
//        algorithm.longestPalindrome2("aa").also {
//            println(it)
//            assert(it == "aa")
//        }
//
//        algorithm.longestPalindrome2("").also {
//            println(it)
//            assert(it == "")
//        }
//        algorithm.longestPalindrome2("ac").also {
//            println(it)
//            assert(it == "a")
//        }
//
//        algorithm.longestPalindrome2("ccc").also {
//            println(it)
//            assert(it == "ccc")
//        }
//        algorithm.longestPalindrome2("azwdzwmwcqzgcobeeiphemqbjtxzwkhiqpbrprocbppbxrnsxnwgikiaqutwpftbiinlnpyqstkiqzbggcsdzzjbrkfmhgtnbujzszxsycmvipjtktpebaafycngqasbbhxaeawwmkjcziybxowkaibqnndcjbsoehtamhspnidjylyisiaewmypfyiqtwlmejkpzlieolfdjnxntonnzfgcqlcfpoxcwqctalwrgwhvqvtrpwemxhirpgizjffqgntsmvzldpjfijdncexbwtxnmbnoykxshkqbounzrewkpqjxocvaufnhunsmsazgibxedtopnccriwcfzeomsrrangufkjfzipkmwfbmkarnyyrgdsooosgqlkzvorrrsaveuoxjeajvbdpgxlcrtqomliphnlehgrzgwujogxteyulphhuhwyoyvcxqatfkboahfqhjgujcaapoyqtsdqfwnijlkknuralezqmcryvkankszmzpgqutojoyzsnyfwsyeqqzrlhzbc").also {
//            println(it)
//            assert(it == "sooos")
//        }
        algorithm.longestPalindrome2("aacbcaa").also {
            println(it)
            assert(it == "aacbcaa")
        }

    }

}