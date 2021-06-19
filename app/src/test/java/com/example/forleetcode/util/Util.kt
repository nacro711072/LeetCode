package com.example.forleetcode.util

fun String.parse2DList_IntArray(): List<IntArray> {
    return substring(1, this.lastIndex)
        .split("[")
        .asSequence()
        .map { it.replace(Regex("][,]?"), "") }
        .filter { it.isNotEmpty() }
        .map { it.split(",").map(String::toInt).toIntArray() }
        .toList()
}

fun String.parse2DList_List(): List<List<Int>> {
    return substring(1, this.lastIndex)
        .split("[")
        .asSequence()
        .map { it.replace(Regex("][,]?"), "") }
        .filter { it.isNotEmpty() }
        .map { it.split(",").map(String::toInt).toList() }
        .toList()

}

fun String.parse2DList_ListString(): List<List<String>> {
    return substring(1, this.lastIndex)
        .split("[")
        .asSequence()
        .map { it.replace(Regex("][,]?"), "") }
        .filter { it.isNotEmpty() }
        .map { it.replace("\"", "").split(",").toList() }
        .toList()

}