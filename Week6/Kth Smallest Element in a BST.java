/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {

    private int count = 0;
    private int result = Integer.MIN_VALUE;

    public int kthSmallest(TreeNode root, int k) {
        traverseInOrder(root, k);
        return result;
    }

    private void traverseInOrder(TreeNode node, int k) {
        if (node == null) {
            return;
        }

        traverseInOrder(node.left, k);

        count++;
        if (count == k) {
            result = node.val;
            return;
        }

        traverseInOrder(node.right, k);
    }
}