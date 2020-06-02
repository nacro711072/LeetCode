package com.example.forleetcode.tree.algorithm

import com.example.forleetcode.tree.model.TreeNode

//Given two binary trees, write a function to check if they are the same or not.
//
//
// Two binary trees are considered the same if they are structurally identical a
//nd the nodes have the same value.
//
// Example 1:
//
//
//Input:     1         1
//          / \       / \
//         2   3     2   3
//
//        [1,2,3],   [1,2,3]
//
//Output: true
//
//
// Example 2:
//
//
//Input:     1         1
//          /           \
//         2             2
//
//        [1,2],     [1,null,2]
//
//Output: false
//
//
// Example 3:
//
//
//Input:     1         1
//          / \       / \
//         2   1     1   2
//
//        [1,2,1],   [1,1,2]
//
//Output: false
//
// Related Topics Tree Depth-first Search

/**
 * Nick, 2020/6/1
 * [100] Same Tree
 */
class SameTree {
    fun isSameTree(p: TreeNode?, q: TreeNode?): Boolean {
        if (p == null && q == null) return true
        return if (p?.`val` == q?.`val`) {
            isSameTree(p?.left, q?.left) && isSameTree(p?.right, q?.right)
        } else {
            false
        }
    }
}