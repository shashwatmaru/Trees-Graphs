public class PrintNodesHavingKLeaves {
    public static class TreeNode{
        TreeNode left;
        TreeNode right;
        int val;
        public TreeNode(int value){
            val = value;
        }
    }
    public int findNumberOfLeaves(TreeNode node, int k){
        if(node == null) return 0;
        if(node.left == null && node.right == null) return 1;
        int totalCount;
        int leftCount = findNumberOfLeaves(node.left,k);
        int rightCount = findNumberOfLeaves(node.right,k);

        totalCount=leftCount+rightCount;
        if(totalCount == k){
            System.out.print(node.val+" ");
        }

        return  totalCount;

    }


    public static void main(String [] args){
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.left.left.left = new TreeNode(8);
        root.left.left.right = new TreeNode(9);

        root.right = new TreeNode(3);
        root.right.left = new TreeNode(6);
        root.right.left.left = new TreeNode(10);
        root.right.left.right = new TreeNode(11);
        root.right.right = new TreeNode(7);
        root.right.right.right = new TreeNode(13);
        root.right.right.left = new TreeNode(12);

        PrintNodesHavingKLeaves printNodesHavingKLeaves = new PrintNodesHavingKLeaves();
        printNodesHavingKLeaves.findNumberOfLeaves(root,2);

    }


}
