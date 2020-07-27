package com.example.forleetcode.tree.algorithm

import com.example.forleetcode.tree.model.TreeNode
import java.util.*

class SymmetricTree101 {
//    BFS
    fun isSymmetric(root: TreeNode?): Boolean {
        val left: Queue<TreeNode?> = LinkedList()
        val right: Queue<TreeNode?> = LinkedList()
        left.offer(root?.left)
        right.offer(root?.right)


        while (true) {
            if (left.all { it == null } && right.all { it == null }) return true
            for (i in 0 until left.size) {
                val l = left.poll()
                val r = right.poll()
                if (l?.`val` != r?.`val`) {
                    return false
                } else {
                    left.offer(l?.left)
                    left.offer(l?.right)
                    right.offer(r?.right)
                    right.offer(r?.left)
                }
            }
        }
    }

    fun isSymmetric2(root: TreeNode?): Boolean {
        return root?.left isSymmetricWith root?.right
    }

    private infix fun TreeNode?.isSymmetricWith(other: TreeNode?): Boolean {
        return if (this?.`val` == other?.`val`) {
            if (this?.`val` == null)
                true
            else
                this.left isSymmetricWith other?.right && this.right isSymmetricWith other?.left
        } else {
            false
        }
    }
}