public class PrintNumberOfLeafNodesInBinaryTree {
    public static class TreeNode {
        TreeNode left;
        TreeNode right;
        int val;
        public TreeNode(int value) {
            val = value;
        }
    }
    int count=0;

    /*
    In this we will increment the count variable when left and right both are null,
    otherwise we will traverse left or right.
     */
    public void printNumberOfLeafs(TreeNode node){
      if(node == null) return;

      if(node.left == null && node.right==null) count++;

      if(node.left != null){
          printNumberOfLeafs(node.left);
      }
      if(node.right != null){
          printNumberOfLeafs(node.right);
      }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);//1
        root.left.left.left = new TreeNode(8);
        root.left.left.right = new TreeNode(9);//1
        root.left.left.left.left = new TreeNode(13);//1
        root.left.left.left.right = new TreeNode(14);//1

        root.right = new TreeNode(3);
        root.right.left = new TreeNode(6);
        root.right.left.left = new TreeNode(10);
        root.right.left.left.left = new TreeNode(15);//1
        root.right.left.left.right = new TreeNode(16);//1
        root.right.left.right = new TreeNode(11);//1
        root.right.right = new TreeNode(7);
        root.right.right.right = new TreeNode(12);
        root.right.right.right.left = new TreeNode(17);//1
        root.right.right.right.right = new TreeNode(18);//1

        PrintNumberOfLeafNodesInBinaryTree printNumberOfLeafNodesInBinaryTree = new PrintNumberOfLeafNodesInBinaryTree();
        printNumberOfLeafNodesInBinaryTree.printNumberOfLeafs(root);
        System.out.println("Number of leafs in tree is: "+printNumberOfLeafNodesInBinaryTree.count);
    }
}
