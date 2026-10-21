
class Solution {
    int minDiff;
    int prev;

    public int getMinimumDifference(TreeNode root) {
        minDiff = Integer.MAX_VALUE;
        prev = -1;

        inorder(root);

        return minDiff;
    }

    private void inorder(TreeNode root) {
        if (root == null) {
            return;
        }

        inorder(root.left);

        if (prev != -1) {
            minDiff = Math.min(minDiff, root.val - prev);
        }

        prev = root.val;

        inorder(root.right);
    }
}
