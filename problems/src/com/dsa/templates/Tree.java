package com.dsa.templates;

import java.util.Queue;
import java.util.Stack;
import javax.swing.tree.TreeNode;

public class Tree {

  //Binary tree: DFS (recursive)
  public int dfs(TreeNode root) {
    if (root == null) {
      return 0;
    }

    int ans = 0;
    // do logic
    dfs(root.left);
    dfs(root.right);
    return ans;
  }

  //Binary tree: DFS (iterative)

  public int dfs(TreeNode root) {
    Stack<TreeNode> stack = new Stack<>();
    stack.push(root);
    int ans = 0;

    while (!stack.empty()) {
      TreeNode node = stack.pop();
      // do logic
      if (node.left != null) {
        stack.push(node.left);
      }
      if (node.right != null) {
        stack.push(node.right);
      }
    }
    return ans;
  }

  //Binary tree: BFS
  public int fn(TreeNode root) {
    Queue<TreeNode> queue = new LinkedList<>();
    queue.add(root);
    int ans = 0;

    while (!queue.isEmpty()) {
      int currentLength = queue.size();
      // do logic for current level

      for (int i = 0; i < currentLength; i++) {
        TreeNode node = queue.remove();
        // do logic
        if (node.left != null) {
          queue.add(node.left);
        }
        if (node.right != null) {
          queue.add(node.right);
        }
      }
    }

    return ans;
  }
}
