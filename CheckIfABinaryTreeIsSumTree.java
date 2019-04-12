public class CheckIfABinaryTreeIsSumTree {
    public static class TreeNode {
        TreeNode left;
        TreeNode right;
        int val;
        public TreeNode(int value) {
            val = value;
        }
    }

    /*
    In this we will find the addition of all the nodes in left side and right side and add them
    and then compare with the value of root node, if it match then we will return true.
    otherwise false.
     */
    public boolean isSumTree(TreeNode root){
        if(root == null) return true;

        if(root.left == null && root.right == null) return  true;

        int leftSum = add(root.left);
        int rightSum = add(root.right);
        int total = leftSum+rightSum;
        if(total == root.val) return  true;

        return  false;
    }

    private int add(TreeNode node){
        if(node == null) return  0;
        int sum = node.val + add(node.left) + add(node.right);

        return  sum;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(56);
        root.left = new TreeNode(14);
        root.left.left = new TreeNode(6);
        root.left.right = new TreeNode(3);
        root.left.left.left = new TreeNode(1);
        root.left.left.right = new TreeNode(2);

        root.right = new TreeNode(15);
        root.right.left = new TreeNode(9);
        root.right.right = new TreeNode(3);
        root.right.right.left = new TreeNode(2);
        root.right.right.right = new TreeNode(1);

        CheckIfABinaryTreeIsSumTree checkIfABinaryTreeIsSumTree = new CheckIfABinaryTreeIsSumTree();
        System.out.println("Is the give tree is sumTree?-> "+checkIfABinaryTreeIsSumTree.isSumTree(root));

    }

}
