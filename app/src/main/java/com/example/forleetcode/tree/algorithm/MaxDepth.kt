package com.example.forleetcode.tree.algorithm

import com.example.forleetcode.tree.model.TreeNode

/**
 * Nick, 2020/6/1
 *
 */
class MaxDepth {
    // [104] Maximum Depth of Binary Tree
    fun maxDepth(root: TreeNode?): Int {
        if (root == null) return 0
        val r = maxDepth(root.right) + 1
        val l = maxDepth(root.left) + 1
        return Math.max(r, l)
    }

}