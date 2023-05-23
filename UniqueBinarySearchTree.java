class UniqueBinarySearchTree {
    public List<TreeNode> generateTrees(int n) {
        List<TreeNode> ans = BST(1,n); 
        return ans;
    }
    
    public List<TreeNode> BST(int start, int end){
        if(start>end){
            List<TreeNode> nullList = new ArrayList<>();
            nullList.add(null);
            return nullList;
        }
        List<TreeNode> ans = new ArrayList<>();
        for(int i=start;i<=end;i++){
             List<TreeNode> left = BST(start,i-1);
             List<TreeNode> right = BST(i+1,end);
             for(TreeNode l:left){
                 for(TreeNode r:right){
                     TreeNode root = new TreeNode(i);
                     root.left = l;
                     root.right = r;
                     ans.add(root);
                 }
             }
        }
        return ans;
    }    
}