package com.example.forleetcode.util

private inline fun String.parse2D(): Sequence<String> {
    return substring(1, this.lastIndex)
        .split("[")
        .asSequence()
        .map { it.replace(Regex("][,]?"), "") }
        .filter { it.isNotEmpty() }
}

fun String.parse2DArray_IntArray(): Array<IntArray> {
    return parse2D()
        .map { it.split(",").map(String::toInt).toIntArray() }
        .toList().toTypedArray()
}

fun String.parse2DArray_CharArray(): Array<CharArray> {
    return parse2D()
        .map { it.replace("\"", "").replace(",", "").toCharArray() }
        .toList().toTypedArray()
}

fun String.parse2DList_List(): List<List<Int>> {
    return parse2D()
        .map { it.split(",").map(String::toInt).toList() }
        .toList()

}

fun String.parse2DList_ListString(): List<List<String>> {
    return parse2D()
        .map { it.replace("\"", "").split(",").toList() }
        .toList()

}