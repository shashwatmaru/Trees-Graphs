public class PrintNodesAtKDistanceFromRoot {
    public static class TreeNode {
        TreeNode left;
        TreeNode right;
        int val;
        public TreeNode(int value) {
            val = value;
        }
    }

    /*
        Here we will taverse to left by decrementing k's value by 1 and when k==0, we will print that element
        Once left node is done we will print the write as well, We are checking till k distance from root, not going below it
        by returning from k==0 to the caller stack.
     */
    public void printNodesAtKDistance(TreeNode root, int k){
        if(root==null) return;
        if(k==0) {
            System.out.print(root.val+" ");
            return;
        }

        printNodesAtKDistance(root.left,k-1);
        printNodesAtKDistance(root.right,k-1);

    }


    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.left.left.left = new TreeNode(8);
        root.left.left.right = new TreeNode(9);
        root.left.left.left.left = new TreeNode(13);
        root.left.left.left.right = new TreeNode(14);


        root.right = new TreeNode(3);
        root.right.left = new TreeNode(6);
        root.right.left.left = new TreeNode(10);
        root.right.left.left.left = new TreeNode(15);
        root.right.left.left.right = new TreeNode(16);
        root.right.left.right = new TreeNode(11);
        root.right.right = new TreeNode(7);
        root.right.right.right = new TreeNode(12);
        root.right.right.right.left = new TreeNode(17);
        root.right.right.right.right = new TreeNode(18);

        PrintNodesAtKDistanceFromRoot printNodesAtKDistanceFromRoot = new PrintNodesAtKDistanceFromRoot();
        printNodesAtKDistanceFromRoot.printNodesAtKDistance(root,2);
    }

}
