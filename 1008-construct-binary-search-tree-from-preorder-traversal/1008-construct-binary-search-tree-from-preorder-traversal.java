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
    int index = 0;
    public TreeNode bstFromPreorder(int[] preorder) {
        // write your code here
        index = 0;
        return build(preorder, Long.MIN_VALUE, Long.MAX_VALUE);
    }
    public TreeNode build(int[] preorder, long lower, long upper) {
        if(index == preorder.length) return null;
        
        int val = preorder[index];
        if(val < lower || val > upper) {
            return null;
        }
        TreeNode root = new TreeNode(val);
        index++;
        root.left = build(preorder, lower, val);
        root.right = build(preorder, val, upper);
        
        return root;
    }
}