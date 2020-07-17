package com.example.forleetcode
//Merge two sorted linked lists and return it as a new sorted list. The new list
// should be made by splicing together the nodes of the first two lists.
//
// Example:
//
//
//Input: 1->2->4, 1->3->4
//Output: 1->1->2->3->4->4
//
// Related Topics Linked List

class MergeTwoSortedList21 {

    data class ListNode(var `val`: Int) {
       var next: ListNode? = null
    }

    fun mergeTwoLists(l1: ListNode?, l2: ListNode?): ListNode? {
        if (l1 == null) return l2
        if (l2 == null) return l1

        var (small, big) = l1 sortNode l2;
        val result = small

        var current = small
        while (small.next != null) {
            (small.next!! sortNode big).also {
                small = it.first
                big = it.second
            }
            current.next = small
            current = small
        }

        current.next = big

        return result
    }

    private infix fun ListNode.sortNode(other: ListNode): Pair<ListNode, ListNode> {
        return if (this.`val` <= other.`val`) this to other else other to this
    }
}
