package com.example.forleetcode.tree.algorithm

import com.example.forleetcode.tree.model.TreeNode
import java.util.*

//Given the root of a binary tree, the level of its root is 1, the level of its
//children is 2, and so on.
//
// Return the smallest level X such that the sum of all the values of nodes at l
//evel X is maximal.
//
//
//
// Example 1:
//
//
//
//
//Input: [1,7,0,7,-8,null,null]
//Output: 2
//Explanation:
//Level 1 sum = 1.
//Level 2 sum = 7 + 0 = 7.
//Level 3 sum = 7 + -8 = -1.
//So we return the level with the maximum sum which is level 2.
//
//
//
//
// Note:
//
//
// The number of nodes in the given tree is between 1 and 10^4.
// -10^5 <= node.val <= 10^5
//
// Related Topics Graph

/**
 * Nick, 2020/6/2
 * [1161] Maximum Level Sum of a Binary Tree
 */
class MaxLevelSum {
//    DFS
    fun maxLevelSum(root: TreeNode?): Int {
        var level = 0
        val sumList: MutableList<Int> = mutableListOf()

        sumNode(root, level, sumList)
        var res = 0 to 0
        sumList.forEachIndexed { index, total ->
            if (total > res.second) {
                res = (index + 1) to total
            }
        }

        return res.first
    }

    private fun sumNode(
        root: TreeNode?,
        level: Int,
        sumList: MutableList<Int>
    ) {
        if (root == null) return

        sumList.getOrNull(level)?.let {
            sumList.set(level, root.`val` + it)
        } ?: kotlin.run {
            sumList.add(level, root.`val`)
        }

        sumNode(root.left, level + 1, sumList)
        sumNode(root.right, level + 1, sumList)
    }

//    BFS
    fun maxLevelSum2(root: TreeNode?): Int {
        var max = Pair(0, 0)
        var level = 1
        if (root == null) return 0

        val queue: Queue<TreeNode> = LinkedList()
        queue.offer(root)

        while (!queue.isEmpty()) {
            var total = 0
            for (i in queue.indices) {
                val node = queue.poll()
                total += node.`val`

                if (node.right != null) queue.offer(node.right)
                if (node.left != null) queue.offer(node.left)
            }

            if (max.second < total) {
                max = level to total
            }

            level++
        }

        return max.first
    }

}