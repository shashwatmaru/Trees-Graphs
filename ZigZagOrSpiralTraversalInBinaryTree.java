import java.util.Stack;

public class ZigZagOrSpiralTraversalInBinaryTree {
    public static class TreeNode{
        TreeNode left;
        TreeNode right;
        int val;
        public TreeNode(int value){
            val = value;
        }
    }
    public void spiralTraverse(TreeNode node){
        Stack<TreeNode> stack1 = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();
        stack1.push(node);
        while(!stack1.empty()|| !stack2.empty()){
                while(!stack1.empty()){
                    TreeNode temp = stack1.pop();
                    System.out.print(temp.val+" ");
                    if(temp.left != null) stack2.push(temp.left);
                    if(temp.right != null) stack2.push(temp.right);
                }
                while(!stack2.empty()){
                    TreeNode temp = stack2.pop();
                    System.out.print(temp.val+" ");
                    if(temp.right != null) stack1.push(temp.right);
                    if(temp.left != null) stack1.push(temp.left);
                }
        }
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
        root.right.right.right = new TreeNode(12);

        ZigZagOrSpiralTraversalInBinaryTree zigZagOrSpiralTraversalInBinaryTree = new ZigZagOrSpiralTraversalInBinaryTree();
        zigZagOrSpiralTraversalInBinaryTree.spiralTraverse(root);
    }
}
