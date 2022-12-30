class ValidateBinaryTreeUsingRecursion {
    public boolean isValidBST(TreeNode root) {
        // Keep LONG to handle MIN and MAX INT case
        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }
    
    private boolean isValidBST(TreeNode root, long min, long max) {
        if (root == null) {
            return true;
        }
        boolean left = isValidBST(root.left, min, root.val);
        boolean right = isValidBST(root.right, root.val, max);
        return root.val < max && root.val > min && left && right;
    }
}